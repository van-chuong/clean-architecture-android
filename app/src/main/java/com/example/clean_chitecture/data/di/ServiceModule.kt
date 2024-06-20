package com.example.clean_chitecture.data.di

import com.example.clean_chitecture.data.source.remote.appwrite.AppwriteManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val serviceModule = module {
    single { AppwriteManager(androidContext()) }
}