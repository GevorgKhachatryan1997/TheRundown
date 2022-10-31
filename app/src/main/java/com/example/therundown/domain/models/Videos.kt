package com.example.therundown.domain.models

import android.os.Parcelable
import com.example.therundown.data.dtos.soccer.dtos.VideoDto
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videos(
    @SerializedName("videos")
    val videos: List<VideoDto?> = listOf()
): Parcelable