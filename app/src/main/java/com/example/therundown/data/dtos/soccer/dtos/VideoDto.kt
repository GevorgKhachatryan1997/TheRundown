package com.example.therundown.data.dtos.soccer.dtos

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class VideoDto(
    @SerializedName("title")
    val title: String? = null,

    @SerializedName("embed")
    val embed: String? = null
): Parcelable