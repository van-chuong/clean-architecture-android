package com.example.clean_chitecture.data.repository

import com.example.clean_chitecture.model.MoviesResponse
import com.example.clean_chitecture.shared.scheduler.DataResult

interface MovieRepository {
    /**
     * Remote
     */

    suspend fun getPopularMovies(page: Int): DataResult<MoviesResponse>

}