package com.example.clean_chitecture.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.clean_chitecture.model.Building
import com.example.clean_chitecture.shared.utils.ConverterUntil

@Database(entities = [(Building::class)], version = 1)
@TypeConverters(ConverterUntil::class)
abstract class BuildingDataBase : RoomDatabase() {

    abstract fun getBuildingDao(): BuildingDao
}
