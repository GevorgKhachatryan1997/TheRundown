package com.example.therundown.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayerFragment : Fragment(R.layout.player_fragment) {

    companion object {
        val TAG = PlayerFragment::class.simpleName
    }

    private val nbaViewModel by viewModel<NbaViewModel>(owner = { requireActivity() })
    private val playerAdapter = PlayerAdapter()
    private val onPlayerItemClickListener = OnPlayerItemClickListener { player ->
        nbaViewModel.onPlayerClick(player.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showNBAPlayers()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.playerList.collect { players ->
                playerAdapter.submitList(players)
            }
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {
                    is NbaViewModel.ShowPlayerInfoDialog -> {
                        PlayerDialog.newInstance(event.player).show(
                            requireActivity().supportFragmentManager,
                            PlayerDialog.PLAYER_DIALOG_TAG
                        )
                    }
                }
            }
        }


        if (nbaViewModel.playerList.value.isEmpty()) {
            nbaViewModel.loadPlayers()
        }
    }

    private fun showNBAPlayers() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.playerRecycleView)
        recyclerView?.apply {
            adapter = playerAdapter
            playerAdapter.onPlayerItemClickListener = onPlayerItemClickListener
            layoutManager = LinearLayoutManager(view?.context)
        }
    }
}