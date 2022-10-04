package com.example.therundown.domain

import com.example.therundown.data.dtos.StatDto

fun StatDto.convertToStat() = Stat(
    id ?: "",
    ast ?: "",
    blk ?: "",
    dreb ?: "",
    fg3_pct ?: "",
    fg3a ?: "",
    fg3m ?: "",
    fg_pct ?: "",
    fgm ?: "",
    ft_pct ?: "",
    fta ?: "",
    ftm ?: "",
    min ?: "",
    oreb ?: "",
    pts ?: "",
    reb ?: "",
    stl ?: "",
    turnover ?: ""
)