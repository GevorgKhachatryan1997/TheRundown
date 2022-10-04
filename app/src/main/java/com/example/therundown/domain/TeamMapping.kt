package com.example.therundown.domain

import com.example.therundown.data.dtos.TeamDto

fun TeamDto.convertToTeam() = Team(
    id ?: "",
    name ?: "",
    fullName ?: "",
    abbreviation ?: "",
    city ?: "",
    conference ?: "",
    division ?: ""
)