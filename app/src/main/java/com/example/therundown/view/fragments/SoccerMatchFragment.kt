package com.example.therundown.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.view.NbaViewModel
import com.example.therundown.view.adapters.OnSoccerMatchItemClickListener
import com.example.therundown.view.adapters.SoccerMatchAdapter
import com.example.therundown.view.dialogs.SoccerMatchDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class SoccerMatchFragment : Fragment(R.layout.soccer_match_fragment) {

    companion object {
        val TAG: String = SoccerMatchFragment::class.java.simpleName
    }

    private val nbaViewModel by viewModel<NbaViewModel>(owner = { requireActivity() })
    private val soccerMatchAdapter = SoccerMatchAdapter()
    private val onSoccerMatchItemClickListener = OnSoccerMatchItemClickListener { soccerMatch ->
        nbaViewModel.onSoccerMatchClick(soccerMatch)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showSoccerMatches()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.soccerMatchList.collect { soccerMatches ->
                soccerMatchAdapter.submitList(soccerMatches)
            }
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {
                    is NbaViewModel.ShowSoccerMatchDialog -> {
                        SoccerMatchDialog.newInstance(event.soccerMatch).show(
                            requireActivity().supportFragmentManager,
                            SoccerMatchDialog.SOCCER_DIALOG_TAG
                        )
                    }
                }
            }
        }

        if (nbaViewModel.soccerMatchList.value.isEmpty()) {
            nbaViewModel.loadSoccerMatches()
        }
    }

    private fun showSoccerMatches() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.soccerMatchRecyclerView)
        recyclerView?.apply {
            adapter = soccerMatchAdapter
            soccerMatchAdapter.onSoccerMatchItemClickListener = onSoccerMatchItemClickListener
            layoutManager = LinearLayoutManager(view?.context)
        }
    }
}