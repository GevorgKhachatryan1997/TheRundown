package com.example.therundown.di

import com.example.therundown.view.NbaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        NbaViewModel(get())
    }
}