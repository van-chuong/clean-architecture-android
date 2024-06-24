package com.example.clean_chitecture.data.di

import android.content.Context
import androidx.room.Room
import com.example.clean_chitecture.data.ConstantData.BUILDING_DATABASE
import com.example.clean_chitecture.data.source.local.BuildingDataBase
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideBuildingDataBase(context: Context): BuildingDataBase =
    Room.databaseBuilder(
        context,
        BuildingDataBase::class.java,
        BUILDING_DATABASE
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

fun provideBuildingDao(buildingDataBase: BuildingDataBase) = buildingDataBase.getBuildingDao()

val dataBaseModule: Module = module {
    single { provideBuildingDataBase(get()) }
    single { provideBuildingDao(get()) }
}