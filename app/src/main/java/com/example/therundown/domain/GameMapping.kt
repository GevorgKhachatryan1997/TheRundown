package com.example.therundown.domain

fun Game.convertToGame() = Game(id ?: "", date ?: "",homeTeam ?: null ,homeTeamScore ?: "", period ?: "")