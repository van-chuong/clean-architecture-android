package com.example.clean_chitecture.data.repository

import com.example.clean_chitecture.model.Movie
import com.example.clean_chitecture.shared.scheduler.DataResult

interface FavoriteRepository {

    suspend fun getFavoriteMovies(): DataResult<MutableList<Movie>>
}