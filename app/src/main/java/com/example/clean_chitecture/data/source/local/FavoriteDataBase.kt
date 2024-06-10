package com.example.clean_chitecture.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clean_chitecture.model.Movie

@Database(entities = [(Movie::class)], version = 1)
abstract class FavoriteDataBase : RoomDatabase() {

    abstract fun getFavoriteDao(): FavoriteDao
}
