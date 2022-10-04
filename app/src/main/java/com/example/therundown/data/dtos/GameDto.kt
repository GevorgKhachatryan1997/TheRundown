package com.example.therundown.data.dtos

import com.example.therundown.domain.models.HomeTeam
import com.example.therundown.domain.models.VisitorTeam
import com.google.gson.annotations.SerializedName

class GameDto(
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
)