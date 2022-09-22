package com.example.therundown.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.therundown.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var bottomNavigationView: BottomNavigationView? = null
    private val nbaViewModel by viewModel<NbaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView?.setOnItemReselectedListener { item ->

            when (item.itemId) {
                R.id.gameBottom -> {
                    val gameFragment = GameFragment()
                    if (savedInstanceState == null) {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace(R.id.fragmentContainer, gameFragment)
                        }
                    }
                }

                R.id.playerBottom -> {
                    val playerFragment = PlayerFragment()
                    if (savedInstanceState == null) {
                        supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace(R.id.fragmentContainer, playerFragment)
                        }
                    }
                }
            }
        }

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

                    is NbaViewModel.ShowPlayerInfoDialog -> {

                    }
                }
            }
        }
    }
}