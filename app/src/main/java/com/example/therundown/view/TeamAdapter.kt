package com.example.therundown.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.Team

class TeamAdapter : ListAdapter<Team, TeamAdapter.TeamViewHolder>(TEAM_DIFF_UTIL) {

    var onTeamItemClickListener: OnTeamItemClickListener? = null

    companion object {
        private val TEAM_DIFF_UTIL = object : DiffUtil.ItemCallback<Team>() {
            override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
                return oldItem == newItem
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team, parent, false)
        return TeamViewHolder(view, onTeamItemClickListener)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TeamViewHolder(itemView: View, onTeamItemClickListener: OnTeamItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        private var tvTeam: TextView = itemView.findViewById(R.id.tvTeam)
        private var team: Team? = null

        init {
            tvTeam.setOnClickListener {
                team?.let {
                    onTeamItemClickListener?.onClick(it)
                }
            }
        }

        fun bind(team: Team) {
            this.team = team
            tvTeam.text = "${team.fullName}"
        }
    }
}

fun interface OnTeamItemClickListener{
    fun onClick(team: Team)
}