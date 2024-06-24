package com.example.clean_chitecture.data.di

import com.example.clean_chitecture.data.repository.BuildingRepository
import com.example.clean_chitecture.data.repository.BuildingRepositoryImpl
import com.example.clean_chitecture.data.repository.MainBuildingRepository
import com.example.clean_chitecture.data.repository.MainBuildingRepositoryImpl
import com.example.clean_chitecture.data.repository.MovieRepository
import com.example.clean_chitecture.data.repository.MovieRepositoryImpl
import com.google.gson.Gson
import org.koin.dsl.module

val repositoryModule = module {
    single { Gson() }

    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }

    single<BuildingRepository> {
        BuildingRepositoryImpl(get(), get())
    }

    single<MainBuildingRepository> {
        MainBuildingRepositoryImpl(get())
    }
}
