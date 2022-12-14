package com.example.therundown.data.dtos

import com.google.gson.annotations.SerializedName

class VisitorTeamDto(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("abbreviation")
    val abbreviation: String? = null,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("conference")
    val conference: String? = null,

    @SerializedName("division")
    val division: String? = null,

    @SerializedName("full_name")
    val fullName: String? = null,

    @SerializedName("name")
    val name: String? = null
)