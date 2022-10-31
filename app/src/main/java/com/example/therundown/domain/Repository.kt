package com.example.therundown.domain

import com.example.therundown.data.RemoteDataSource
import com.example.therundown.domain.mapping.convertToSoccerMatch

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getPlayers() = remoteDataSource
        .getPlayers()
        .map { playerDto -> playerDto.convertToPlayer() }

    fun getPlayer(id: String) = remoteDataSource.getPlayer(id).convertToPlayer()

    fun getGames() = remoteDataSource
        .getGames()
        .map { gameDto -> gameDto.convertToGame() }

    fun getGame(id: String) = remoteDataSource.getGame(id).convertToGame()

    fun getTeams() = remoteDataSource
        .getTeams()
        .map { teamDto -> teamDto.convertToTeam() }

    fun getTeam(id: String) = remoteDataSource.getTeam(id).convertToTeam()

    fun getStats() = remoteDataSource
        .getStats()
        .map { statDto -> statDto.convertToStat() }

    fun getSoccerMatches() = remoteDataSource
        .getSoccerMatches()
        .map { soccerMatchDto -> soccerMatchDto.convertToSoccerMatch() }
}