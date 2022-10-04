package com.example.therundown.domain

import com.example.therundown.data.dtos.StatDto
import com.example.therundown.data.models.Stat

fun StatDto.convertToStat() = Stat(
    id ?: "",
    ast ?: "",
    blk ?: "",
    dreb ?: "",
    fg3Pct ?: "",
    fg3a ?: "",
    fg3m ?: "",
    fgPct ?: "",
    fgm ?: "",
    ftPct ?: "",
    fta ?: "",
    ftm ?: "",
    min ?: "",
    oreb ?: "",
    pts ?: "",
    reb ?: "",
    stl ?: "",
    turnover ?: ""
)