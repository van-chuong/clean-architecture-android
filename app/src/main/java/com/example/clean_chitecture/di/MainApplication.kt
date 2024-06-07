package com.example.clean_chitecture.di

import android.app.Application
import com.example.data.di.dataBaseModule
import com.example.data.di.dataSourceModule
import com.example.data.di.entityMapperModule
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            repositoryModule,
            entityMapperModule,
            itemMapperModule,
            networkModule,
            dataBaseModule,
            dataSourceModule,
            useCaseModule,
            viewModelModule,
        )
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}