package com.example.data.source

import com.example.data.source.remote.response.MovieResponse

interface MovieDataSource {

    interface Local

    interface Remote {
        suspend fun getPopularMovies(page: Int): MovieResponse
    }
}