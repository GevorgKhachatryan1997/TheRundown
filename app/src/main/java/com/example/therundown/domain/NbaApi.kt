package com.example.therundown.domain

import com.example.therundown.data.Data
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object NbaApi {

    private const val BASE_URL = "https://free-nba.p.rapidapi.com/"

    private val nbaService by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NbaService::class.java)
    }

    @Throws(IOException::class)
    fun getPlayers(): Response<Data> {
        return nbaService.getPlayers().execute()
    }
}