package com.example.therundown.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.therundown.R
import com.example.therundown.view.fragments.GameFragment
import com.example.therundown.view.fragments.PlayerFragment
import com.example.therundown.view.fragments.StatFragment
import com.example.therundown.view.fragments.TeamFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var bottomNavigationView: BottomNavigationView? = null
    private val nbaViewModel by viewModel<NbaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
            showGameFragment()
        }

        bottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.gameBottom -> {
                    showGameFragment()
                }

                R.id.playerBottom -> {
                    showPlayerFragment()
                }

                R.id.teamBottom -> {
                    showTeamFragment()
                }

                R.id.statBottom -> {
                    showStatFragment()
                }

                else -> return@setOnItemSelectedListener false
            }
            return@setOnItemSelectedListener true
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
                }
            }
        }
    }

    private fun showGameFragment() {
        val gameFragment =
            supportFragmentManager.findFragmentByTag(GameFragment.TAG) ?: GameFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, gameFragment, GameFragment.TAG)
        }
    }

    private fun showPlayerFragment() {
        val playerFragment =
            supportFragmentManager.findFragmentByTag(PlayerFragment.TAG) ?: PlayerFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, playerFragment, PlayerFragment.TAG)
        }
    }

    private fun showTeamFragment() {
        val teamFragment =
            supportFragmentManager.findFragmentByTag(TeamFragment.TAG) ?: TeamFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, teamFragment, TeamFragment.TAG)
        }
    }

    private fun showStatFragment() {
        val statFragment =
            supportFragmentManager.findFragmentByTag(StatFragment.TAG) ?: StatFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainer, statFragment, StatFragment.TAG)
        }
    }
}