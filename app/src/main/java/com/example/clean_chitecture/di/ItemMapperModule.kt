package com.example.clean_chitecture.di

import com.example.clean_chitecture.model.MovieItemMapper
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val itemMapperModule: Module = module {
    single { androidContext().resources }
    single<MovieItemMapper> { MovieItemMapper(get()) }
}