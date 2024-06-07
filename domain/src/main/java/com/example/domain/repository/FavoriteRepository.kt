package com.example.domain.repository

import com.example.domain.repository.base.Repository
import com.example.domain.model.Movie


interface FavoriteRepository : Repository {
    suspend fun getFavoriteMovies(): List<Movie>
}