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

    var onItemClickListener: OnItemClickListener? = null

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

        return NbaViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: NbaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class NbaViewHolder(view: View, onItemClickListener: OnItemClickListener?) :
    RecyclerView.ViewHolder(view) {

    private var nbaTextView: TextView = view.findViewById(R.id.nbaTextView)
    private var player: Player? = null

    init {
        nbaTextView.setOnClickListener {
            player?.let {
                onItemClickListener?.onClick(it)
            }
        }
    }

    fun bind(player: Player) {
        this.player = player
        nbaTextView.text = player.firstName
    }
}

interface OnItemClickListener {
    fun onClick(player: Player)
}
