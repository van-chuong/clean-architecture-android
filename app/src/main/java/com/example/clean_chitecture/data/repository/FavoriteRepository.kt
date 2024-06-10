package com.example.clean_chitecture.data.repository

import androidx.lifecycle.LiveData
import com.example.clean_chitecture.shared.scheduler.DataResult
import com.example.clean_chitecture.model.Movie

interface FavoriteRepository {

    suspend fun getFavoriteMovies(): DataResult<MutableList<Movie>>
}