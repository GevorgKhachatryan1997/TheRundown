package com.example.therundown.data

import com.example.therundown.domain.Game
import com.example.therundown.domain.PlayerDto
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

    fun getGames(): List<Game> {
        val responseGameDto = nbaApi.getGames()
        return if (responseGameDto.isSuccessful) {
            responseGameDto.body()!!.data
        } else emptyList()
    }

    fun getPlayer(id: String): PlayerDto? {
        val player = nbaApi.getPlayer(id)
        return if (player.isSuccessful) {
            player.body()!!
        } else {
            null
        }
    }

    fun getGame(id: String): Game? {
        val game = nbaApi.getGame(id)
        return if (game.isSuccessful) {
            game.body()!!
        } else {
            null
        }
    }
}
