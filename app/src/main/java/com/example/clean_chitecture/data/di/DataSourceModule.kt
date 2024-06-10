package com.example.clean_chitecture.data.di

import com.example.clean_chitecture.data.source.FavoriteDataSource
import com.example.clean_chitecture.data.source.MovieDataSource
import com.example.clean_chitecture.data.source.local.FavoriteLocalImpl
import com.example.clean_chitecture.data.source.remote.MovieRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MovieDataSource.Remote> {
        MovieRemoteImpl(get())
    }
    single<FavoriteDataSource.Local> {
        FavoriteLocalImpl(get())
    }
}