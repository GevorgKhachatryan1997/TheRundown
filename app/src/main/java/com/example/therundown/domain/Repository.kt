package com.example.therundown.domain

import com.example.therundown.data.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getPlayers() = remoteDataSource
        .getPlayers()
        .map { playerDto -> playerDto.convertToPlayer() }

    fun getGames() = remoteDataSource.getGames().map { gameDto -> gameDto.convertToGame()  }

    fun getPlayer(id: String) = remoteDataSource.getPlayer(id)

    fun getGame(id: String) = remoteDataSource.getGame(id)
}