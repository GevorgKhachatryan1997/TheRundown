package com.example.therundown.domain

import com.example.therundown.data.dtos.PlayerDto
import com.example.therundown.domain.models.Player
import com.example.therundown.domain.models.Team

fun PlayerDto.convertToPlayer() = Player(
    id ?: "",
    firstName ?: "",
    team ?: Team(
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )
)

