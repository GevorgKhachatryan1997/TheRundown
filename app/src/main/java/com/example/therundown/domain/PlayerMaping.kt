package com.example.therundown.domain

fun PlayerDto.convertToPlayer() = Player(id.toString(), lastName.toString())