package com.example.therundown.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Game(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("date")
    val date: String? = null,

    @SerializedName("home_team")
    val homeTeam: HomeTeam? = null,

    @SerializedName("home_team_score")
    val homeTeamScore: String? = null,

    @SerializedName("period")
    val period: String? = null,

    @SerializedName("postseason")
    val postseason: Boolean? = null,

    @SerializedName("season")
    val season: String? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("time")
    val time: String? = null,

    @SerializedName("visitor_team")
    val visitorTeam: VisitorTeam? = null,

    @SerializedName("visitor_team_score")
    val visitorTeamScore: String? = null
) : Serializable {
    override fun equals(other: Any?): Boolean {
        return other is Game &&
                other.id == id &&
                other.date == date &&
                other.homeTeam == homeTeam &&
                other.homeTeamScore == homeTeamScore &&
                other.period == period &&
                other.postseason == postseason &&
                other.season == season &&
                other.status == status &&
                other.time == time &&
                other.visitorTeam == visitorTeam &&
                other.visitorTeamScore == visitorTeamScore
    }
}

