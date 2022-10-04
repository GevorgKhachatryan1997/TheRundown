package com.example.therundown.data

import com.example.therundown.data.dtos.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface NbaService {

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("players")
    fun getPlayers(): Call<Players>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("players/{id}")
    fun getPlayer(@Path("id") id: String): Call<PlayerDto>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("games")
    fun getGames(): Call<Games>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("games/{id}")
    fun getGame(@Path("id") id: String): Call<GameDto>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("teams")
    fun getTeams(): Call<Teams>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("teams/{id}")
    fun getTeam(@Path("id") id: String): Call<TeamDto>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("stats")
    fun getStats(): Call<Stats>
}