package com.example.clean_chitecture.data.di

import com.example.clean_chitecture.data.repository.FavoriteRepository
import com.example.clean_chitecture.data.repository.FavoriteRepositoryImpl
import com.example.clean_chitecture.data.repository.MovieRepository
import com.example.clean_chitecture.data.repository.MovieRepositoryImpl
import com.google.gson.Gson
import org.koin.dsl.module

val repositoryModule = module {
    single { Gson() }

    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }

    single<FavoriteRepository> {
        FavoriteRepositoryImpl(get())
    }

}
