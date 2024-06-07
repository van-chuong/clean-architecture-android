package com.example.data.di

import com.example.data.model.MovieEntityMapper
import org.koin.core.module.Module
import org.koin.dsl.module

val entityMapperModule: Module = module {
    single<MovieEntityMapper> { MovieEntityMapper() }
}