package com.example.therundown.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VisitorTeam(
    val id: Int? = null,
    val abbreviation: String? = null,
    val city: String? = null,
    val conference: String? = null,
    val division: String? = null,
    val fullName: String? = null,
    val name: String? = null
) : Parcelable