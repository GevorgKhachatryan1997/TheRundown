package com.example.therundown.domain

fun GameDto.convertToGame() =
    Game(
        id ?: "",
        date ?: "",
        homeTeam ?: HomeTeam(
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        ),
        homeTeamScore ?: "",
        period ?: ""
    )