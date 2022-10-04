package com.example.therundown.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val id: String,
    val firstName: String,
    val team: Team
) : Parcelable