package com.example.therundown.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.therundown.R
import com.example.therundown.domain.Stat

class StatAdapter : ListAdapter<Stat, StatViewHolder>(STAT_DIFF_UTIL) {

    var onStatItemClickListener: OnStatItemClickListener? = null

    companion object {
        private val STAT_DIFF_UTIL = object : DiffUtil.ItemCallback<Stat>() {
            override fun areItemsTheSame(oldItem: Stat, newItem: Stat): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Stat, newItem: Stat): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): StatViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.stat, viewGroup, false)
        return StatViewHolder(view, onStatItemClickListener)
    }

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class StatViewHolder(view: View, onStatItemClickListener: OnStatItemClickListener?) :
    RecyclerView.ViewHolder(view) {

    private val tvStatId: TextView = view.findViewById(R.id.tvStat)
    private var stat: Stat? = null

    init {
        tvStatId.setOnClickListener {
            stat?.let {
                onStatItemClickListener?.onClick(it)
            }
        }
    }

    fun bind(stat: Stat) {
        this.stat = stat
        tvStatId.text = stat.id
    }
}

fun interface OnStatItemClickListener {
    fun onClick(stat: Stat)
}