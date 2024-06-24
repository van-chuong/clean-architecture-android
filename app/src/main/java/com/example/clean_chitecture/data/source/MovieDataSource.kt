package com.example.clean_chitecture.data.source

import com.example.clean_chitecture.model.MoviesResponse

interface MovieDataSource {

    interface Local

    interface Remote {
        suspend fun getPopularMovies(page: Int): MoviesResponse
    }
}