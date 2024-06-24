package com.example.clean_chitecture.data.repository

import android.util.Log
import com.example.clean_chitecture.data.source.MovieDataSource
import com.example.clean_chitecture.model.MoviesResponse
import com.example.clean_chitecture.shared.scheduler.DataResult


class MovieRepositoryImpl(
    private val moviesDataSource: MovieDataSource.Remote,
) : MovieRepository {

    override suspend fun getPopularMovies(page: Int): DataResult<MoviesResponse> {
        return try {
            val response = moviesDataSource.getPopularMovies(page)
            DataResult.Success(response)
        } catch (e: Exception) {
            Log.d("Dataaaaa", e.toString())
            DataResult.Error(e)
        }
    }

}