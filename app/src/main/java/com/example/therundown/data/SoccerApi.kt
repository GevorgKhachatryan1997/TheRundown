package com.example.therundown.data

import com.example.therundown.data.dtos.*
import com.example.therundown.data.dtos.soccer.dtos.SoccerMatches
import retrofit2.Response
import java.io.IOException

const val SOCCER_BASE_URL = "https://free-football-soccer-videos1.p.rapidapi.com/v1/"

class SoccerApi(private val soccerService: SoccerService) {

    @Throws(IOException::class)
    fun getSoccerMatches(): Response<SoccerMatches> {
        return soccerService.getSoccerMatches().execute()
    }
}