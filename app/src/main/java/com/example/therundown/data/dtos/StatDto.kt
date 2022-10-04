package com.example.therundown.data.dtos

import com.example.therundown.domain.Game
import com.example.therundown.domain.Player
import com.google.gson.annotations.SerializedName

class StatDto(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("ast")
    val ast: String? = null,

    @SerializedName("blk")
    val blk: String? = null,

    @SerializedName("dreb")
    val dreb: String? = null,

    @SerializedName("fg3_pct")
    val fg3_pct: String? = null,

    @SerializedName("fg3a")
    val fg3a: String? = null,

    @SerializedName("fg3m")
    val fg3m: String? = null,

    @SerializedName("fg_pct")
    val fg_pct: String? = null,

    @SerializedName("fgm")
    val fgm: String? = null,

    @SerializedName("ft_pct")
    val ft_pct: String? = null,

    @SerializedName("fta")
    val fta: String? = null,

    @SerializedName("ftm")
    val ftm: String? = null,

    @SerializedName("game")
    val game: Game? = null,

    @SerializedName("min")
    val min: String? = null,

    @SerializedName("oreb")
    val oreb: String? = null,

    @SerializedName("player")
    val player: Player? = null,

    @SerializedName("pts")
    val pts: String? = null,

    @SerializedName("reb")
    val reb: String? = null,

    @SerializedName("stl")
    val stl: String? = null,

    @SerializedName("team")
    val team: TeamDto? = null,

    @SerializedName("turnover")
    val turnover: String? = null
) {
}