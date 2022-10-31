package com.example.therundown.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SoccerMatch(
    val title: String,
    val embed: String,
    val url: String,
    val thumbnail: String,
    val date: String,
    val sideOne: SideOne,
    val sideTwo: SideTwo,
    val compilation: Compilation,
    val videos: Videos
) : Parcelable