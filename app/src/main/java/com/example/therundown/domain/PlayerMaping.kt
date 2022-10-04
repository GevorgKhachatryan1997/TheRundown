package com.example.therundown.domain

import com.example.therundown.data.dtos.PlayerDto
import com.example.therundown.data.dtos.TeamDto
import com.example.therundown.data.models.Player
import com.example.therundown.data.models.Team

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

