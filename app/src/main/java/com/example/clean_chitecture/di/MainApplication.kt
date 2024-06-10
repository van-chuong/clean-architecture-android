package com.example.clean_chitecture.di

import android.app.Application
import com.example.clean_chitecture.data.di.dataBaseModule
import com.example.clean_chitecture.data.di.dataSourceModule
import com.example.clean_chitecture.data.di.networkModule
import com.example.clean_chitecture.data.di.repositoryModule
import com.example.clean_chitecture.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(
            networkModule,
            repositoryModule,
            dataBaseModule,
            dataSourceModule,
            viewModelModule,
        )
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}