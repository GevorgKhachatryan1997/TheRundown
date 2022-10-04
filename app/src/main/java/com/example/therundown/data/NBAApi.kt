package com.example.therundown.data

import com.example.therundown.data.dtos.*
import retrofit2.Response
import java.io.IOException

const val NBA_BASE_URL = "https://free-nba.p.rapidapi.com/"

class NBAApi(private val nbaService: NbaService) {

    @Throws(IOException::class)
    fun getPlayers(): Response<Players> {
        return nbaService.getPlayers().execute()
    }

    @Throws(IOException::class)
    fun getPlayer(id: String): Response<PlayerDto> {
        return nbaService.getPlayer(id).execute()
    }

    @Throws(IOException::class)
    fun getGames(): Response<Games> {
        return nbaService.getGames().execute()
    }

    @Throws(IOException::class)
    fun getGame(id: String): Response<GameDto> {
        return nbaService.getGame(id).execute()
    }

    @Throws(IOException::class)
    fun getTeams(): Response<Teams> {
        return nbaService.getTeams().execute()
    }

    @Throws(IOException::class)
    fun getTeam(id: String): Response<TeamDto> {
        return nbaService.getTeam(id).execute()
    }

    @Throws(IOException::class)
    fun getStats(): Response<Stats> {
        return nbaService.getStats().execute()
    }
}