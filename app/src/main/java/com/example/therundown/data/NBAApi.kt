package com.example.therundown.data

import com.example.therundown.domain.Game
import com.example.therundown.domain.PlayerDto
import retrofit2.Response
import java.io.IOException

const val NBA_BASE_URL = "https://free-nba.p.rapidapi.com/"

class NBAApi(private val nbaService: NbaService) {

    @Throws(IOException::class)
    fun getPlayers(): Response<DataPlayer> {
        return nbaService.getPlayers().execute()
    }

    @Throws(IOException::class)
    fun getGames(): Response<DataGame> {
        return nbaService.getGames().execute()
    }

    @Throws(IOException::class)
    fun getPlayer(id: String): Response<PlayerDto> {
        return nbaService.getPlayer(id).execute()
    }

    @Throws(IOException::class)
    fun getGame(id: String): Response<Game> {
        return nbaService.getGame(id).execute()
    }
}