package com.example.therundown.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.view.NbaViewModel
import com.example.therundown.view.adapters.OnStatItemClickListener
import com.example.therundown.view.adapters.StatAdapter
import com.example.therundown.view.dialogs.StatDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatFragment : Fragment(R.layout.stat_fragment) {

    companion object {
        val TAG = StatFragment::class.simpleName
    }

    private val nbaViewModel by viewModel<NbaViewModel>(owner = { requireActivity() })
    private val statAdapter = StatAdapter()
    private val onStatItemClickListener = OnStatItemClickListener { stat ->
        stat.let { nbaViewModel.onStatClick(it) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showStats()
        lifecycleScope.launchWhenCreated {
            nbaViewModel.statList.collect { stats ->
                statAdapter.submitList(stats)
            }
        }

        lifecycleScope.launchWhenCreated {
            nbaViewModel.uiEventSharedFlow.collect { event ->
                when (event) {
                    is NbaViewModel.ShowStatInfoDialog -> {
                        StatDialog.newInstance(event.stat).show(
                            requireActivity().supportFragmentManager,
                            StatDialog.STAT_DIALOG_TAG
                        )
                    }
                }
            }
        }

        if (nbaViewModel.statList.value.isEmpty()) {
            nbaViewModel.loadStats()
        }
    }

    private fun showStats() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.statRecyclerView)
        recyclerView?.apply {
            adapter = statAdapter
            statAdapter.onStatItemClickListener = onStatItemClickListener
            layoutManager = LinearLayoutManager(view?.context)
        }
    }
}