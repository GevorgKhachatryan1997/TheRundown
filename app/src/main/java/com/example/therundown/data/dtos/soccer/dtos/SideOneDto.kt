package com.example.therundown.data.dtos.soccer.dtos

import com.google.gson.annotations.SerializedName

class SideOneDto(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("url")
    val url: String? = null
)