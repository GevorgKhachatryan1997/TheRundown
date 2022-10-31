package com.example.therundown.domain.mapping

import com.example.therundown.data.dtos.soccer.dtos.SoccerMatchDto
import com.example.therundown.domain.models.*


fun SoccerMatchDto.convertToSoccerMatch() = SoccerMatch(
    title ?: "",
    embed ?: "",
    url ?: "",
    thumbnail ?: "",
    date ?: "",
    (sideOne ?: "") as SideOne,
    (sideTwo ?: "") as SideTwo,
    (compilation ?: "") as Compilation,
    (videos ?: "") as Videos
)