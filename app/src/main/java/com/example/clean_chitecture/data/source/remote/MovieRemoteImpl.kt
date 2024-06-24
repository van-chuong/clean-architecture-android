package com.example.clean_chitecture.data.source.remote

import com.example.clean_chitecture.data.source.MovieDataSource
import com.example.clean_chitecture.data.source.remote.api.MovieApi
import com.example.clean_chitecture.model.MoviesResponse

class MovieRemoteImpl(private val movieApi: MovieApi) : MovieDataSource.Remote {
    override suspend fun getPopularMovies(page: Int): MoviesResponse = movieApi.getMoviePopular(page)
}