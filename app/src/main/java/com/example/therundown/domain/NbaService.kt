package com.example.therundown.domain

import com.example.therundown.data.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface NbaService {

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("players")
    fun getPlayers(): Call<Data>
}