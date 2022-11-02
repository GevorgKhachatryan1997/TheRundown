package com.example.therundown.data

import com.example.therundown.data.dtos.*
import com.example.therundown.data.dtos.soccer.dtos.SoccerMatchDto
import com.example.therundown.data.dtos.soccer.dtos.SoccerMatches
import retrofit2.Response
import java.io.IOException
import java.util.Objects

const val SOCCER_BASE_URL = "https://free-football-soccer-videos1.p.rapidapi.com/"

class SoccerApi(private val soccerService: SoccerService) {

    @Throws(IOException::class)
    fun getSoccerMatches(): Response<List<SoccerMatchDto>> {
        return soccerService.getSoccerMatches().execute()
    }
}