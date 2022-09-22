package com.example.therundown.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.Player
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerFragment : Fragment(R.layout.player_fragment) {

    private var twId: TextView? = null
    private var twName: TextView? = null
    private var twFullName: TextView? = null
    private var twDivision: TextView? = null
    private var twCity: TextView? = null
    private var twConference: TextView? = null
    private var recyclerView: RecyclerView? = null
    private val nbaAdapter = PlayerAdapter()
    private val nbaViewModel by viewModel<NbaViewModel>()
    private val onItemClickListener = object : OnItemClickListener {
        override fun onClick(player: Player) {
            nbaViewModel.onPlayerClick(player.id)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*twId?.text = "id ${player.team.id.toString()}"
        twName?.text = "name ${player.team.name}"
        twFullName?.text = "fullname ${player.team.fullName}"
        twDivision?.text = "division ${player.team.division}"
        twCity?.text = "city ${player.team.city}"
        twConference?.text = "Conference ${player.team.conference}"
    */
        showNBAPlayers()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.playerList.collect { players ->
                nbaAdapter.submitList(players)
            }
        }

        if (savedInstanceState == null) {
            nbaViewModel.loadPlayers()
        }
    }

    private fun showNBAPlayers() {
        recyclerView = view?.findViewById(R.id.playerRecycleView)
        recyclerView?.apply {
            adapter = nbaAdapter
            nbaAdapter.onItemClickListener = onItemClickListener
            layoutManager = LinearLayoutManager(view?.context)
        }
    }
}