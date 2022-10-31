package com.example.therundown.data.dtos.soccer.dtos

import com.google.gson.annotations.SerializedName

class VideosDto(
    @SerializedName("videos")
    val videos: List<VideoDto?> = listOf()
)