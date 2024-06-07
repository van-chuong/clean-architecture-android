package com.example.data.di

import com.example.data.repository.MovieRepositoryImpl
import com.example.domain.repository.MovieRepository
import com.google.gson.Gson
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single { Gson() }
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}