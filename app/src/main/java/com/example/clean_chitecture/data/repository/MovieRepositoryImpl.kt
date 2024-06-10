package com.example.clean_chitecture.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.clean_chitecture.shared.scheduler.DataResult
import com.example.clean_chitecture.data.source.MovieDataSource
import com.example.clean_chitecture.model.MoviesResponse


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