package com.example.therundown.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.models.Game

class GameAdapter : ListAdapter<Game, GameAdapter.GameViewHolder>(GameDiffUtilItemCallback()) {

    var onGameItemClickListener: OnGameItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.game, viewGroup, false)
        return GameViewHolder(view, onGameItemClickListener)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class GameViewHolder(itemView: View, onGameItemClickListener: OnGameItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        private var tvGameName: TextView = itemView.findViewById(R.id.tvGameId)
        private var game: Game? = null

        init {
            tvGameName.setOnClickListener {
                game?.let {
                    onGameItemClickListener?.onClick(it)
                }
            }
        }

        fun bind(game: Game) {
            this.game = game
            tvGameName.text = "${game.date}"
        }
    }
}

class GameDiffUtilItemCallback : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }
}

fun interface OnGameItemClickListener {
    fun onClick(game: Game)
}
