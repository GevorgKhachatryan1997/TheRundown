package com.example.therundown.di

import com.example.therundown.data.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val NBA_BASE_URL_NAME = "NBA_BASE_URL_Key"
private const val SOCCER_BASE_URL_NAME = "SOCCER_BASE_URL_Key"

val dataModule = module {

    factory {
        RemoteDataSource(get())
    }

    factory {
        NBAApi(get())
    }

    factory {
        Retrofit
            .Builder()
            .baseUrl(get<String>(named(NBA_BASE_URL_NAME)))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NbaService::class.java)
    }

    factory {
        Retrofit
            .Builder()
            .baseUrl(get<String>(named(SOCCER_BASE_URL_NAME)))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SoccerService::class.java)
    }

    factory(named(NBA_BASE_URL_NAME)) {
        NBA_BASE_URL
    }

    factory(named(SOCCER_BASE_URL_NAME)) {
        SOCCER_BASE_URL
    }
}