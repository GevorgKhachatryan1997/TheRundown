package com.example.therundown.domain

fun TeamDto.convertToTeam() = Team(
    id ?: "",
    name ?: "",
    fullName ?: "",
    abbreviation ?: "",
    city ?: "",
    conference ?: "",
    division ?: ""
)