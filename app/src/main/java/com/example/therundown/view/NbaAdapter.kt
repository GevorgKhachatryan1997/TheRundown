package com.example.therundown.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.Player

class NbaAdapter : ListAdapter<Player, NbaViewHolder>(DIFF_UTIL) {

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Player>() {
            override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NbaViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.nba_player, viewGroup, false)

        return NbaViewHolder(view)
    }

    override fun onBindViewHolder(holder: NbaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NbaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var nbaTextView: TextView = view.findViewById(R.id.nbaTextView)

    fun bind(player: Player) {
        nbaTextView.text = player.lastName
    }
}
