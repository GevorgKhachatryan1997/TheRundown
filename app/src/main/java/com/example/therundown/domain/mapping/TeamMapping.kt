package com.example.therundown.domain

import com.example.therundown.data.dtos.TeamDto
import com.example.therundown.domain.models.Team

fun TeamDto.convertToTeam() = Team(
    id ?: "",
    name ?: "",
    fullName ?: "",
    abbreviation ?: "",
    city ?: "",
    conference ?: "",
    division ?: ""
)