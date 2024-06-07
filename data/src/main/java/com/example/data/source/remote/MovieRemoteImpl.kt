package com.example.data.source.remote

import com.example.data.model.MovieEntity
import com.example.data.source.MovieDataSource
import com.example.data.source.remote.api.MovieApi
import com.example.data.source.remote.response.MovieResponse

class MovieRemoteImpl(private val movieApi: MovieApi) : MovieDataSource.Remote {
    override suspend fun getPopularMovies(page: Int): MovieResponse = movieApi.getMoviePopular(page)
}