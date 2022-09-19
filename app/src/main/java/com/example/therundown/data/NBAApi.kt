package com.example.therundown.data

import retrofit2.Response
import java.io.IOException

const val NBA_BASE_URL = "https://free-nba.p.rapidapi.com/"

class NBAApi(private val nbaService: NbaService) {

    @Throws(IOException::class)
    fun getPlayers(): Response<Data> {
        return nbaService.getPlayers().execute()
    }
}