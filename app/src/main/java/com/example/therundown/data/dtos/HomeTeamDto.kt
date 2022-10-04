package com.example.therundown.data.dtos

import com.google.gson.annotations.SerializedName

class HomeTeamDto(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("division")
    val division: String? = null,

    @SerializedName("conference")
    val conference: String? = null,

    @SerializedName("abbreviation")
    val abbreviation: String? = null
)