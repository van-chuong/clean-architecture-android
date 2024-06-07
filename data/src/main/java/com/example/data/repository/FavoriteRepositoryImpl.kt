package com.example.data.repository

import com.example.data.model.MovieEntityMapper
import com.example.data.source.FavoriteDataSource
import com.example.domain.model.Movie
import com.example.domain.repository.FavoriteRepository

class FavoriteRepositoryImpl(
    private val favoriteDataSource: FavoriteDataSource.Local,
    private val movieEntityMapper: MovieEntityMapper
) : FavoriteRepository {

    override suspend fun getFavoriteMovies(): List<Movie> {
        val response = favoriteDataSource.getFavoriteMovies()
        return response.map { movieEntityMapper.mapToDomain(it) }
    }
}