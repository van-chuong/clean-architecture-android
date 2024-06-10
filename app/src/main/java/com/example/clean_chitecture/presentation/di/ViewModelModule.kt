package com.example.clean_chitecture.presentation.di

import com.example.clean_chitecture.presentation.views.home.HomeViewModel
import com.example.clean_chitecture.presentation.views.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}
