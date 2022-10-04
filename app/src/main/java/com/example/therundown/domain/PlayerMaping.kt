package com.example.therundown.domain

import com.example.therundown.data.dtos.PlayerDto
import com.example.therundown.data.dtos.TeamDto

fun PlayerDto.convertToPlayer() = Player(
    id ?: "",
    firstName?: "",
    team?: TeamDto("","","","","","","")
)

