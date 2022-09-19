package com.example.therundown.data

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
}