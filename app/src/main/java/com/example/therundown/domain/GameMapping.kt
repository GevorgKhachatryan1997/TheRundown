package com.example.therundown.domain

import com.example.therundown.data.dtos.GameDto
import com.example.therundown.data.models.Game
import com.example.therundown.data.models.HomeTeam

fun GameDto.convertToGame() =
    Game(id ?: "",
        date ?: "",
        homeTeam ?: HomeTeam("", "", "", "", "", "", ""),
        homeTeamScore ?: "",
        period ?: "",
        postseason ?: false,
        season ?: "",
        status ?: ""
    )