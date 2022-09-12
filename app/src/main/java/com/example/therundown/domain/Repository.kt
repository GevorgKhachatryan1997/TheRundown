package com.example.therundown.domain

import com.example.therundown.data.RemoteDataSource

object Repository {

    fun getPlayers() = RemoteDataSource()
        .getPlayers()
        .map { playerDto -> playerDto.convertToPlayer() }


}