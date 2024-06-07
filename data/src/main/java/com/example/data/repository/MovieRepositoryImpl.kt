package com.example.data.repository

import com.example.data.model.MovieEntityMapper
import com.example.data.source.MovieDataSource
import com.example.domain.model.Movie
import com.example.domain.repository.MovieRepository


class MovieRepositoryImpl(
    private val moviesDataSource: MovieDataSource.Remote,
    private val movieEntityMapper: MovieEntityMapper
) : MovieRepository {

    override suspend fun getMoviePopular(page: Int): List<Movie> {
        val response = moviesDataSource.getPopularMovies(page)
        return response.mListMovie.map { movieEntityMapper.mapToDomain(it) }
    }

}