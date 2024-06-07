package com.example.data.di

import com.example.data.source.FavoriteDataSource
import com.example.data.source.MovieDataSource
import com.example.data.source.local.FavoriteLocalImpl
import com.example.data.source.remote.MovieRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MovieDataSource.Remote> {
        MovieRemoteImpl(get())
    }
    single<FavoriteDataSource.Local> {
        FavoriteLocalImpl(get())
    }

}