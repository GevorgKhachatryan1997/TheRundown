package com.example.therundown.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.therundown.R

class MainActivity : AppCompatActivity() {

    private val nbaViewModel: NbaViewModel by lazy { ViewModelProvider(this)[NbaViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.playerList.collect { players ->
                //TODO create new player class for view
                players.forEach { player ->
                    Log.d("player", player.firstName.toString())
                }
            }
        }

        if (savedInstanceState == null) {
            nbaViewModel.loadPlayers()
        }
    }
}