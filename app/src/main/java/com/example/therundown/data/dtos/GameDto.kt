package com.example.therundown.data.dtos

import com.example.therundown.domain.HomeTeam
import com.example.therundown.domain.VisitorTeam
import com.google.gson.annotations.SerializedName

class GameDto(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("date")
    val date: String? = null,

    @SerializedName("homeTeam")
    val homeTeam: HomeTeam? = null,

    @SerializedName("homeTeamScore")
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

    @SerializedName("visitorTeam")
    val visitorTeam: VisitorTeam? = null,

    @SerializedName("visitorTeamScore")
    val visitorTeamScore: String? = null
)

