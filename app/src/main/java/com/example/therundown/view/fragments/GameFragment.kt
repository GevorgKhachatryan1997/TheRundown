package com.example.therundown.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.view.adapters.GameAdapter
import com.example.therundown.view.NbaViewModel
import com.example.therundown.view.adapters.OnGameItemClickListener
import com.example.therundown.view.dialogs.GameDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment(R.layout.game_fragment) {

    companion object {
        val TAG = GameFragment::class.simpleName
    }

    private val nbaViewModel by viewModel<NbaViewModel>(owner = { requireActivity() })
    private val gameAdapter = GameAdapter()
    private val onGameItemClickListener = OnGameItemClickListener { game ->
        game.id?.let { nbaViewModel.onGameClick(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showGames()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.gameList.collect { games ->
                gameAdapter.submitList(games)
            }
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {
                    is NbaViewModel.ShowGameInfoDialog -> {
                        GameDialog.newInstance(event.game).show(
                            requireActivity().supportFragmentManager,
                            GameDialog.GAME_DIALOG_TAG
                        )
                    }
                }
            }
        }

        if (nbaViewModel.gameList.value.isEmpty()) {
            nbaViewModel.loadGames()
        }
    }

    private fun showGames() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.gameRecycleView)
        recyclerView?.apply {
            adapter = gameAdapter
            gameAdapter.onGameItemClickListener = onGameItemClickListener
            layoutManager = LinearLayoutManager(view?.context)
        }
    }
}