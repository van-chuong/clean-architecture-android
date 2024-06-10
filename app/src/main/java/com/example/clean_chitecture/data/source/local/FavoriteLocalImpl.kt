package com.example.clean_chitecture.data.source.local

import androidx.lifecycle.LiveData
import com.example.clean_chitecture.data.source.FavoriteDataSource
import com.example.clean_chitecture.model.Movie

class FavoriteLocalImpl(private val favoriteDao: FavoriteDao) : FavoriteDataSource.Local {
    override suspend fun getFavoriteMovies(): MutableList<Movie> = favoriteDao.getAllFavorites()
}
