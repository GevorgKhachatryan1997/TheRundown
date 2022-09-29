package com.example.therundown.domain

import java.io.Serializable

class Game(
    val id: String? = null,
    val date: String? = null,
    val homeTeam: HomeTeam? = null,
    val homeTeamScore: String? = null,
    val period: String? = null,
    val postseason: Boolean? = null,
    val season: String? = null,
    val status: String? = null,
) : Serializable {
    override fun equals(other: Any?): Boolean {
        return other is GameDto &&
                other.id == id &&
                other.date == date &&
                other.homeTeam == homeTeam &&
                other.homeTeamScore == homeTeamScore &&
                other.period == period &&
                other.postseason == postseason &&
                other.season == season &&
                other.status == status
    }
}