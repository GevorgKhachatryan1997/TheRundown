package com.example.therundown.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SoccerMatch(
    val title: String = "",
    val embed: String = "",
    val url: String = "",
    val thumbnail: String = "",
    val date: String = "",
    val sideOne: Side = Side(),
    val sideTwo: Side = Side(),
    val compilation: Compilation = Compilation(),
    val videos: List<Video> = emptyList()
) : Parcelable