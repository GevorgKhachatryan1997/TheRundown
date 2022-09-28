package com.example.therundown.domain

fun PlayerDto.convertToPlayer() = Player(
    id ?: "",
    firstName?: "",
    team?: TeamDto(null,"","","","","",""))

