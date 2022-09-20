package com.example.therundown.domain

import com.google.gson.annotations.SerializedName

class PlayerDto(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("first_name")
    val firstName: String? = null,

    @SerializedName("height_feet")
    val heightFeet: String? = null,

    @SerializedName("height_inches")
    val heightInches: String? = null,

    @SerializedName("last_name")
    val lastName: String? = null,

    @SerializedName("position")
    val position: String? = null,

    @SerializedName("team")
    val team: TeamDto? = null
)