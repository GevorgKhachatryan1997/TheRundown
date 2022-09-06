package com.example.therundown.data

import com.example.therundown.domain.NbaApi
import com.example.therundown.domain.PlayerDto
import java.io.IOException
import kotlin.jvm.Throws

object Repository {

    @Throws(ServerExeption::class, PlayerLoadExeption::class)
    fun getPlayers(): List<PlayerDto> {
        val response = NbaApi.getPlayers()

        try {
            if (response.isSuccessful) {
                return response.body()!!.data
            } else {
                val message = " ${response.code()} ${response.errorBody()}"
                throw ServerExeption(message)
            }
        } catch (i: IOException) {
            throw PlayerLoadExeption("Unable to get player list", i)
        }
    }
}