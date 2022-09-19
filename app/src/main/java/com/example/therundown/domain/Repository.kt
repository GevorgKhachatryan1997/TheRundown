package com.example.therundown.domain

import com.example.therundown.data.RemoteDataSource

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getPlayers() = remoteDataSource
        .getPlayers()
        .map { playerDto -> playerDto.convertToPlayer() }
}