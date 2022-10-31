package com.example.therundown.data.dtos.soccer.dtos

import com.google.gson.annotations.SerializedName

class CompilationDto(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("url")
    val url: String? = null
)