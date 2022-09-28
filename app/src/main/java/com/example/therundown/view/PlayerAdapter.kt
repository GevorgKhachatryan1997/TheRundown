package com.example.therundown.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.Player

class PlayerAdapter : ListAdapter<Player, PlayerViewHolder>(PLAYER_DIFF_UTIL) {

    var onPlayerItemClickListener: OnPlayerItemClickListener? = null

    companion object {
        private val PLAYER_DIFF_UTIL = object : DiffUtil.ItemCallback<Player>() {
            override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.player, viewGroup, false)
        return PlayerViewHolder(view, onPlayerItemClickListener)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PlayerViewHolder(view: View, onPlayerItemClickListener: OnPlayerItemClickListener?) :
    RecyclerView.ViewHolder(view) {

    private val playerNameTextView: TextView = view.findViewById(R.id.playerNameTextView)
    private val btnTeam: Button = view.findViewById(R.id.btnTeam)
    private var player: Player? = null

    init {
        btnTeam.setOnClickListener {
            player?.let {
                onPlayerItemClickListener?.onClick(it)
            }
        }
    }

    fun bind(player: Player) {
        this.player = player
        playerNameTextView.text = player.firstName
    }
}

fun interface OnPlayerItemClickListener {
    fun onClick(player: Player)
}