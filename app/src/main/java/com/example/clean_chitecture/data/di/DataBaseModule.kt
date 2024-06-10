package com.example.clean_chitecture.data.di

import android.content.Context
import androidx.room.Room
import com.example.clean_chitecture.data.ConstantData.FAVORITE_DATABASE
import com.example.clean_chitecture.data.source.local.FavoriteDataBase
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideFavoriteDataBase(context: Context): FavoriteDataBase =
    Room.databaseBuilder(
        context,
        FavoriteDataBase::class.java,
        FAVORITE_DATABASE
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

fun provideFavoriteDao(favoriteDataBase: FavoriteDataBase) = favoriteDataBase.getFavoriteDao()

val dataBaseModule: Module = module {
    single { provideFavoriteDataBase(get()) }
    single { provideFavoriteDao(get()) }
}