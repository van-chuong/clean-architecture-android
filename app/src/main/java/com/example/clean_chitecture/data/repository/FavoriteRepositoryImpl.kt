package com.example.clean_chitecture.data.repository

import androidx.lifecycle.LiveData
import com.example.clean_chitecture.shared.scheduler.DataResult
import com.example.clean_chitecture.data.source.FavoriteDataSource
import com.example.clean_chitecture.model.Movie

class FavoriteRepositoryImpl(
    private val favoriteDataSource: FavoriteDataSource.Local,
) : FavoriteRepository {

    override suspend fun getFavoriteMovies(): DataResult<MutableList<Movie>> {
        return try {
            val response = favoriteDataSource.getFavoriteMovies()
            DataResult.Success(response)
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }
}