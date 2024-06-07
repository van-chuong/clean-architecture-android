package com.example.data.source.local

import com.example.data.model.MovieEntity
import com.example.data.source.FavoriteDataSource

class FavoriteLocalImpl(private val favoriteDao: FavoriteDao) : FavoriteDataSource.Local {
    override suspend fun getFavoriteMovies(): MutableList<MovieEntity> = favoriteDao.getAllFavorites()
}
