package com.example.clean_chitecture.di

import com.example.clean_chitecture.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(),get()) }
}
