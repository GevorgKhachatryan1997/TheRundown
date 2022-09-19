package com.example.therundown.di

import com.example.therundown.domain.Repository
import org.koin.dsl.module


val domainModule = module {

    factory {
        Repository(get())
    }
}