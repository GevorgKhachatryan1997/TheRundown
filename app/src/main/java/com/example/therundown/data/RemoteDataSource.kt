package com.example.therundown.data

import com.example.therundown.data.dtos.GameDto
import com.example.therundown.data.dtos.PlayerDto
import com.example.therundown.data.dtos.StatDto
import com.example.therundown.data.dtos.TeamDto
import java.io.IOException

class RemoteDataSource(private val nbaApi: NBAApi) {

    @Throws(ServerExeption::class, PlayerLoadExeption::class)
    fun getPlayers(): List<PlayerDto> {
        val responsePlayers = nbaApi.getPlayers()

        try {
            if (responsePlayers.isSuccessful) {
                return responsePlayers.body()!!.data
            } else {
                val message = " ${responsePlayers.code()} ${responsePlayers.errorBody()}"
                throw ServerExeption(message)
            }
        } catch (i: IOException) {
            throw PlayerLoadExeption("Unable to get player list", i)
        }
    }

    fun getPlayer(id: String): PlayerDto? {
        val player = nbaApi.getPlayer(id)
        return if (player.isSuccessful) {
            player.body()!!
        } else {
            null
        }
    }

    fun getGames(): List<GameDto> {
        val responseGameDto = nbaApi.getGames()
        return if (responseGameDto.isSuccessful) {
            responseGameDto.body()!!.data
        } else emptyList()
    }

    fun getGame(id: String): GameDto? {
        val game = nbaApi.getGame(id)
        return if (game.isSuccessful) {
            game.body()!!
        } else {
            null
        }
    }

    fun getTeams(): List<TeamDto> {
        val responseTeams = nbaApi.getTeams()
        return if (responseTeams.isSuccessful) {
            responseTeams.body()!!.data
        } else emptyList()
    }

    fun getTeam(id: String): TeamDto? {
        val team = nbaApi.getTeam(id)
        return if (team.isSuccessful) {
            team.body()!!
        } else {
            null
        }
    }

    fun getStats(): List<StatDto> {
        val responseStats = nbaApi.getStats()
        return if (responseStats.isSuccessful) {
            responseStats.body()!!.data
        } else emptyList()
    }
}
