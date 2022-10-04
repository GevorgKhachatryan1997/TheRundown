package com.example.therundown.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val id: String,
    val firstName: String,
    val team: Team
) : Parcelable