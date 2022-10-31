package com.example.therundown.data.dtos.soccer.dtos

import com.example.therundown.domain.models.Videos
import com.google.gson.annotations.SerializedName

class SoccerMatchDto(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("embed")
    val embed: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("thumbnail")
    val thumbnail: String? = null,

    @SerializedName("date")
    val date: String? = null,

    @SerializedName("side1")
    val sideOne: SideOneDto? = null,

    @SerializedName("side2")
    val sideTwo: SideTwoDto? = null,

    @SerializedName("competition")
    val compilation: CompilationDto? = null,

    @SerializedName("videos")
    val videos: Videos? = null
    )
