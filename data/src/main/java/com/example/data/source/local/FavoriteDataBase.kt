package com.example.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.MovieEntity

@Database(entities = [(MovieEntity::class)], version = 1)
abstract class FavoriteDataBase : RoomDatabase() {

    abstract fun getFavoriteDao(): FavoriteDao
}
