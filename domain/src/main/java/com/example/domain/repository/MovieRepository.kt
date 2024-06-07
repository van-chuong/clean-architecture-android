package com.example.domain.repository

import com.example.domain.model.Movie
import com.example.domain.repository.base.Repository

interface MovieRepository : Repository {
    suspend fun getMoviePopular(page: Int): List<Movie>
}