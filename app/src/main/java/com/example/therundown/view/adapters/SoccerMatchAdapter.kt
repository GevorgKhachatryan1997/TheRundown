package com.example.therundown.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.models.SoccerMatch

class SoccerMatchAdapter: ListAdapter<SoccerMatch, SoccerMatchAdapter.SoccerMatchViewHolder>(SoccerMatchDiffUtilItemCallback()) {

    var onSoccerMatchItemClickListener: OnSoccerMatchItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SoccerMatchViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.soccer_match, viewGroup, false)
        return SoccerMatchViewHolder(view, onSoccerMatchItemClickListener)
    }

    override fun onBindViewHolder(holder: SoccerMatchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SoccerMatchViewHolder(itemView: View, onSoccerMatchItemClickListener: OnSoccerMatchItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        private var btnSoccerMatch: Button = itemView.findViewById(R.id.btnSoccerMatch)
        private var soccerMatch: SoccerMatch? = null

        init {
            btnSoccerMatch.setOnClickListener {
                soccerMatch?.let {
                    onSoccerMatchItemClickListener?.onClick(it)
                }
            }
        }

        fun bind(soccerMatch: SoccerMatch) {
            this.soccerMatch = soccerMatch
            btnSoccerMatch.text = soccerMatch.title
        }
    }
}

class SoccerMatchDiffUtilItemCallback : DiffUtil.ItemCallback<SoccerMatch>() {
    override fun areItemsTheSame(oldItem: SoccerMatch, newItem: SoccerMatch): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: SoccerMatch, newItem: SoccerMatch): Boolean {
        return oldItem == newItem
    }
}

fun interface OnSoccerMatchItemClickListener {
    fun onClick(soccerMatch: SoccerMatch)
}