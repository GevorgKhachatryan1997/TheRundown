package com.example.therundown.data

import com.example.therundown.data.dtos.soccer.dtos.SoccerMatchDto
import com.example.therundown.data.dtos.soccer.dtos.SoccerMatches
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.Objects

interface SoccerService {

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c"])
    @GET("v1/")
    fun getSoccerMatches(): Call<List<SoccerMatchDto>>
}