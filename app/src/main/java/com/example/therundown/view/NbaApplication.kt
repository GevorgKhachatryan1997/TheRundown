package com.example.therundown.view

import android.app.Application
import com.example.therundown.di.appModule
import com.example.therundown.di.dataModule
import com.example.therundown.di.domainModule
import org.koin.core.context.startKoin

class NbaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}