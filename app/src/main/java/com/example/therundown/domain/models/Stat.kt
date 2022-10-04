package com.example.therundown.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stat(
    val id: String,
    val ast: String,
    val blk: String,
    val dreb: String,
    val fg3_pct: String,
    val fg3a: String,
    val fg3m: String,
    val fg_pct: String,
    val fgm: String,
    val ft_pct: String,
    val fta: String,
    val ftm: String,
    val min: String,
    val oreb: String,
    val pts: String,
    val reb: String,
    val stl: String,
    val turnover: String
) : Parcelable