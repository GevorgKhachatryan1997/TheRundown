package com.example.therundown.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val title: String? = null,
    val embed: String? = null
) : Parcelable