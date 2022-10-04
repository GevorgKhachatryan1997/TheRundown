package com.example.therundown.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VisitorTeam(
    val id: Int,
    val abbreviation: String? = null,
    val city: String? = null,
    val conference: String? = null,
    val division: String? = null,
    val fullName: String? = null,
    val name: String? = null
) : Parcelable