package com.example.therundown.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val id: String? = null,
    val date: String? = null,
    val homeTeam: HomeTeam? = null,
    val homeTeamScore: String? = null,
    val period: String? = null,
    val postseason: Boolean? = null,
    val season: String? = null,
    val status: String? = null,
) : Parcelable