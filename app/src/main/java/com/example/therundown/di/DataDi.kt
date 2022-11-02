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
        RemoteDataSource(get(), get())
    }

    factory {
        NBAApi(get())
    }

    factory {
        SoccerApi(get())
    }

    factory {
        createRetrofit<NbaService>(get(named(NBA_BASE_URL_NAME)))
    }

    factory {
        createRetrofit<SoccerService>(get(named(SOCCER_BASE_URL_NAME)))
    }

    factory(named(NBA_BASE_URL_NAME)) {
        NBA_BASE_URL
    }

    factory(named(SOCCER_BASE_URL_NAME)) {
        SOCCER_BASE_URL
    }
}

private inline fun <reified T> createRetrofit(baseUrl: String): T {
    return Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(T::class.java)
}