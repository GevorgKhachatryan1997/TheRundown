package com.example.therundown.data

import com.example.therundown.data.dtos.GameDto
import com.example.therundown.data.dtos.PlayerDto
import com.example.therundown.data.dtos.StatDto
import com.example.therundown.data.dtos.TeamDto
import com.example.therundown.data.dtos.soccer.dtos.SoccerMatchDto
import com.example.therundown.data.exeptions.*
import retrofit2.Response
import java.io.IOException

class RemoteDataSource(
    private val nbaApi: NBAApi,
    private val soccerApi: SoccerApi) {

    @Throws(ServerExeption::class, PlayerLoadExeption::class)
    fun getPlayers(): List<PlayerDto> {
        try {
            val responsePlayers = nbaApi.getPlayers()
            val players = ensureResponse(
                responsePlayers,
                " ${responsePlayers.code()} ${responsePlayers.errorBody()}"
            )
            return players?.data ?: emptyList()
        } catch (i: IOException) {
            throw PlayerLoadExeption("Unable to get player list", i)
        }
    }

    @Throws(ServerExeption::class, PlayerLoadExeption::class)
    fun getPlayer(id: String): PlayerDto {
        try {
            val playerResponse = nbaApi.getPlayer(id)
            val player = ensureResponse(
                playerResponse,
                " ${playerResponse.code()} ${playerResponse.errorBody()}"
            )
            return player!!
        } catch (i: IOException) {
            throw PlayerLoadExeption("Unable to get player")
        }
    }

    @Throws(ServerExeption::class, GameLoadExeption::class)
    fun getGames(): List<GameDto> {
        try {
            val responseGames = nbaApi.getGames()
            val games = ensureResponse(
                responseGames,
                " ${responseGames.code()} ${responseGames.errorBody()}"
            )
            return games?.data ?: emptyList()
        } catch (i: IOException) {
            throw GameLoadExeption("Unable to get game list")
        }
    }

    @Throws(ServerExeption::class, GameLoadExeption::class)
    fun getGame(id: String): GameDto {
        try {
            val gameResponse = nbaApi.getGame(id)
            val game = ensureResponse(
                gameResponse,
                " ${gameResponse.code()} ${gameResponse.errorBody()}"
            )
            return game!!
        } catch (i: IOException) {
            throw GameLoadExeption("Unable to get game")
        }
    }

    @Throws(ServerExeption::class, TeamLoadExeption::class)
    fun getTeams(): List<TeamDto> {
        try {
            val responseTeams = nbaApi.getTeams()
            val stats = ensureResponse(
                responseTeams,
                " ${responseTeams.code()} ${responseTeams.errorBody()}"
            )
            return stats?.data ?: emptyList()
        } catch (i: IOException) {
            throw TeamLoadExeption("Unable to get team list")
        }
    }

    @Throws(ServerExeption::class, TeamLoadExeption::class)
    fun getTeam(id: String): TeamDto {
        try {
            val teamResponse = nbaApi.getTeam(id)
            val team = ensureResponse(
                teamResponse,
                " ${teamResponse.code()} ${teamResponse.errorBody()}"
            )
            return team!!
        } catch (i: IOException) {
            throw TeamLoadExeption("Unable to get team")
        }
    }

    @Throws(ServerExeption::class, TeamLoadExeption::class)
    fun getStats(): List<StatDto> {
        try {
            val responseStats = nbaApi.getStats()
            val stats = ensureResponse(
                responseStats,
                " ${responseStats.code()} ${responseStats.errorBody()}"
            )
            return stats?.data ?: emptyList()
        } catch (i: IOException) {
            throw  StatLoadExeption("Unable to get stat list")
        }
    }

    @Throws(ServerExeption::class, TeamLoadExeption::class)
    fun getSoccerMatches(): List<SoccerMatchDto>{
        try {
            val responseStats = soccerApi.getSoccerMatches()
            val stat = ensureResponse(responseStats,"${responseStats.code()} ${responseStats.errorBody()}"
            )
            return stat?.data ?: emptyList()
        }catch (i: IOException){
            throw SoccerMatchLoadExeption("Unable to get soccer match list")
        }
    }

    private fun <T> ensureResponse(response: Response<T>, errorMessage: String?): T? {
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw ServerExeption(message = errorMessage)
        }
    }
}
