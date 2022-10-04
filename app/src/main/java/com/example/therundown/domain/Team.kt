package com.example.therundown.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Team(
    val id: String? = null,
    val name: String? = null,
    val fullName: String? = null,
    val abbreviation: String? = null,
    val city: String? = null,
    val conference: String? = null,
    val division: String? = null
) : Parcelable