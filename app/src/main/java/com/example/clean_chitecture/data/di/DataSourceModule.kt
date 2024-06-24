package com.example.clean_chitecture.data.di

import com.example.clean_chitecture.data.source.BuildingDataSource
import com.example.clean_chitecture.data.source.MainBuildingDatasource
import com.example.clean_chitecture.data.source.MovieDataSource
import com.example.clean_chitecture.data.source.local.BuildingLocalImpl
import com.example.clean_chitecture.data.source.local.MainBuildingLocalImpl
import com.example.clean_chitecture.data.source.remote.BuildingRemoteImpl
import com.example.clean_chitecture.data.source.remote.MovieRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<MovieDataSource.Remote> {
        MovieRemoteImpl(get())
    }


    single<BuildingDataSource.Local> {
        BuildingLocalImpl(get())
    }

    single<BuildingDataSource.Remote> {
        BuildingRemoteImpl(get())
    }

    single<MainBuildingDatasource.Local> {
        MainBuildingLocalImpl(get())
    }
}