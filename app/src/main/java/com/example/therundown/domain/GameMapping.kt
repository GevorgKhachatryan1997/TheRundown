package com.example.therundown.domain

import com.example.therundown.data.dtos.GameDto

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