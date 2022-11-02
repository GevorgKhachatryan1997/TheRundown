package com.example.therundown.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.example.therundown.R
import com.example.therundown.utils.showShortToast
import com.example.therundown.view.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var bottomNavigationView: BottomNavigationView? = null
    private val nbaViewModel by viewModel<NbaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
            showFragment(GameFragment.TAG)
        }

        bottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.gameBottom -> {
                    showFragment(GameFragment.TAG)
                }

                R.id.playerBottom -> {
                    showFragment(PlayerFragment.TAG)
                }

                R.id.teamBottom -> {
                    showFragment(TeamFragment.TAG)
                }

                R.id.statBottom -> {
                    showFragment(StatFragment.TAG)
                }

                R.id.soccerMatchBottom -> {
                    showFragment(SoccerMatchFragment.TAG)
                }

                else -> return@setOnItemSelectedListener false
            }
            return@setOnItemSelectedListener true
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {
                    is NbaViewModel.ShowServerFailMessage -> {
                        showShortToast("Cant get data")
                    }

                    is NbaViewModel.ShowPlayerLoadFailMessage -> {
                        showShortToast("Cant get players list")
                    }

                    is NbaViewModel.ShowGameLoadFailMessage -> {
                        showShortToast("Cant get games list")
                    }

                    is NbaViewModel.ShowTeamLoadFailMessage -> {
                        showShortToast("Cant get teams list")
                    }

                    is NbaViewModel.ShowStatLoadFailMessage -> {
                        showShortToast("Cant get stats list")
                    }

                    is NbaViewModel.ShowSoccerMatchLoadFailMessage -> {
                        showShortToast("Cant get soccer matches list")
                    }
                }
            }
        }
    }

    private fun showFragment(tag: String) {
        when (tag) {

            GameFragment.TAG -> {
                val gameFragment = supportFragmentManager.findFragmentByTag(tag) ?: GameFragment()
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, gameFragment, tag)
                }
            }

            PlayerFragment.TAG -> {
                val playerFragment =
                    supportFragmentManager.findFragmentByTag(tag) ?: PlayerFragment()
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, playerFragment, tag)
                }
            }

            TeamFragment.TAG -> {
                val teamFragment = supportFragmentManager.findFragmentByTag(tag) ?: TeamFragment()
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, teamFragment, tag)
                }
            }

            StatFragment.TAG -> {
                val statFragment = supportFragmentManager.findFragmentByTag(tag) ?: StatFragment()
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, statFragment, tag)
                }
            }

            SoccerMatchFragment.TAG -> {
                val soccerMatchFragment =
                    supportFragmentManager.findFragmentByTag(tag) ?: SoccerMatchFragment()
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, soccerMatchFragment, tag)
                }
            }
        }
    }
}