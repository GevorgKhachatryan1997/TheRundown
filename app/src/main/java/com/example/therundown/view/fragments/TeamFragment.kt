package com.example.therundown.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.view.NbaViewModel
import com.example.therundown.view.adapters.OnTeamItemClickListener
import com.example.therundown.view.adapters.TeamAdapter
import com.example.therundown.view.dialogs.TeamDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : Fragment(R.layout.team_fragment) {

    companion object{
        val TAG = TeamFragment::class.simpleName
    }

    private val nbaViewModel by viewModel<NbaViewModel>(owner = { requireActivity() })
    private val teamAdapter = TeamAdapter()
    private val onTeamItemClickListener = OnTeamItemClickListener { team ->
        team.id?.let { nbaViewModel.onTeamClick(team.id) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showGames()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.teamList.collect { teams ->
                teamAdapter.submitList(teams)
            }
        }

        if (nbaViewModel.teamList.value.isEmpty()) {
            nbaViewModel.loadTeams()
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {
                    is NbaViewModel.ShowTeamInfoDialog -> {
                        TeamDialog.newInstance(event.team).show(
                            requireActivity().supportFragmentManager,
                            TeamDialog.TEAM_DIALOG_TAG
                        )
                    }
                }
            }
        }
    }

    private fun showGames() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.teamRecycleView)
        recyclerView?.apply {
            adapter = teamAdapter
            teamAdapter.onTeamItemClickListener = onTeamItemClickListener
            layoutManager = LinearLayoutManager(view?.context)
        }
    }
}