package com.example.clean_chitecture.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.clean_chitecture.model.Movie


@Dao
interface FavoriteDao {

    @Query("SELECT * FROM movie")
    suspend fun getAllFavorites(): MutableList<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Movie)

    @Delete
    suspend fun deleteFavorite(favorite: Movie)

    @Query("DELETE FROM movie")
    suspend fun deleteAllFavorites()
}
