package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository
import com.example.domain.shared.scheduler.DataResult
import com.example.domain.usecase.UseCase


class GetMovieUseCase(
    private val movieRepository: MovieRepository
) : UseCase<GetMovieUseCase.Params, DataResult<List<Movie>>>() {

    override suspend fun createObservable(param: Params?): DataResult<List<Movie>> {
        if (param == null) {
            throw IllegalArgumentException("Params can't be null")
        }
        return try {
            val movies = movieRepository.getMoviePopular(param.page)
            DataResult.Success(movies)
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }

    override fun onCleared() {
        // Clean up resources if needed
    }

    data class Params(val page: Int)
}