package com.example.clean_chitecture.data.source

import com.example.clean_chitecture.model.Movie

interface FavoriteDataSource {

    interface Local {

        suspend fun getFavoriteMovies(): MutableList<Movie>
    }

    interface Remote
}