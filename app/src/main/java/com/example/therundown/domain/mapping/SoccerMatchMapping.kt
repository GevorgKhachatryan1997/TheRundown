package com.example.therundown.domain.mapping

import com.example.therundown.data.dtos.soccer.dtos.CompilationDto
import com.example.therundown.data.dtos.soccer.dtos.SideDto
import com.example.therundown.data.dtos.soccer.dtos.SoccerMatchDto
import com.example.therundown.data.dtos.soccer.dtos.VideoDto
import com.example.therundown.domain.models.*


fun SoccerMatchDto.convertToSoccerMatch() = SoccerMatch(
    title ?: "",
    embed ?: "",
    url ?: "",
    thumbnail ?: "",
    date ?: "",
    sideOne?.convertToSide() ?: Side(),
    sideTwo?.convertToSide() ?: Side(),
    compilation?.convertToCompilation() ?: Compilation(),
    videos?.map { video -> video.convertToVideos() }.orEmpty()
)

private fun SideDto.convertToSide() = Side(name ?: "", url ?: "")

private fun CompilationDto.convertToCompilation() = Compilation(
    name ?: "",
    id ?: "",
    url ?: ""
)

private fun VideoDto.convertToVideos() = Video(title ?: "", embed ?: "")