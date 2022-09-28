package com.example.therundown.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment(R.layout.game_fragment) {

    companion object {
        val TAG = GameFragment::class.simpleName
    }

    private val nbaViewModel by viewModel<NbaViewModel>(owner = { requireActivity() })
    private val gameAdapter = GameAdapter()
    private val onGameItemClickListener = OnGameItemClickListener { gameDto ->
        gameDto.id?.let { nbaViewModel.onGameDtoClick(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showGames()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.gameList.collect { game ->
                gameAdapter.submitList(game)
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