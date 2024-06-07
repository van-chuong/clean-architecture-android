package com.example.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.MovieEntity


@Dao
interface FavoriteDao {

    @Query("SELECT * FROM movie")
    suspend fun getAllFavorites(): MutableList<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: MovieEntity)

    @Delete
    suspend fun deleteFavorite(favorite: MovieEntity)

    @Query("DELETE FROM movie")
    suspend fun deleteAllFavorites()
}
