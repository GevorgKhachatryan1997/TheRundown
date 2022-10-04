package com.example.therundown.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeTeam(
    val id: String,
    val name: String,
    val fullName: String,
    val city: String,
    val division: String,
    val conference: String,
    val abbreviation: String
): Parcelable