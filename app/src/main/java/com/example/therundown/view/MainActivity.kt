package com.example.therundown.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private val nbaAdapter = NbaAdapter()
    private val nbaViewModel: NbaViewModel by lazy { ViewModelProvider(this)[NbaViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycleView()

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
                nbaAdapter.submitList(players)
            }
        }

        if (savedInstanceState == null) {
            nbaViewModel.loadPlayers()
        }
    }

    private fun initRecycleView() {
        recyclerView = findViewById(R.id.nbaRecycleView)
        recyclerView?.adapter = nbaAdapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
    }
}