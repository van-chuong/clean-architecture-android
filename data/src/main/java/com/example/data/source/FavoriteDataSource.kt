package com.example.data.source

import com.example.data.model.MovieEntity

interface FavoriteDataSource {

    interface Local {

        suspend fun getFavoriteMovies(): MutableList<MovieEntity>
    }

    interface Remote
}