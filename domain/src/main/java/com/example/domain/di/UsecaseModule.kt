package com.example.domain.di

import com.example.domain.usecase.movie.GetMovieUseCase
import org.koin.core.module.Module
import org.koin.dsl.module


val useCaseModule: Module = module {
    single<GetMovieUseCase>() { GetMovieUseCase(get()) }
}