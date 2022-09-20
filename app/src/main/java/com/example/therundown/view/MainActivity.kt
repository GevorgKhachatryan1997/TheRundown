package com.example.therundown.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.Player
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val onItemClickListener = object : OnItemClickListener {
        override fun onClick(player: Player) {
            nbaViewModel.onPlayerClick(player.id)
        }

    }
    private var recyclerView: RecyclerView? = null
    private val nbaAdapter = NbaAdapter()
    private val nbaViewModel by viewModel<NbaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNBAPlayers()

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {

                    is NbaViewModel.ShowServerFailMessage -> {
                        Toast.makeText(
                            this@MainActivity,
                            "cant get players list",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is NbaViewModel.ShowPlayerLoadFailMessage -> {
                        Toast.makeText(
                            this@MainActivity,
                            "cant get players list",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is NbaViewModel.ShowPlayer -> {
                        val playerFragment = PlayerFragment.newInstance(event.player)
                        playerFragment.show(supportFragmentManager, PlayerFragment.TAG)
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.playerList.collect { players ->
                players.forEach { player ->
                    Log.d("player", player.id)
                }
                nbaAdapter.submitList(players)
            }
        }

        if (savedInstanceState == null) {
            nbaViewModel.loadPlayers()
        }
    }

    private fun showNBAPlayers() {
        recyclerView = findViewById(R.id.nbaRecycleView)
        recyclerView?.apply {
            adapter = nbaAdapter
            nbaAdapter.onItemClickListener = onItemClickListener
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}