package com.example.therundown.data

import com.example.therundown.data.dtos.GameDto
import com.example.therundown.data.dtos.PlayerDto
import com.example.therundown.data.dtos.StatDto
import com.example.therundown.data.dtos.TeamDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface NbaService {

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("players")
    fun getPlayers(): Call<DataPlayer>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("players/{id}")
    fun getPlayer(@Path("id") id: String): Call<PlayerDto>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("games")
    fun getGames(): Call<DataGame>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("games/{id}")
    fun getGame(@Path("id") id: String): Call<GameDto>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("teams")
    fun getTeams(): Call<DataTeam>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("teams/{id}")
    fun getTeam(@Path("id") id: String): Call<TeamDto>

    @Headers(value = ["X-RapidAPI-Key: d55fee44fcmsh35def730cef21dfp1f3e66jsn78117291062c", "X-RapidAPI-Host: free-nba.p.rapidapi.com"])
    @GET("stats")
    fun getStats(): Call<DataStat>
}