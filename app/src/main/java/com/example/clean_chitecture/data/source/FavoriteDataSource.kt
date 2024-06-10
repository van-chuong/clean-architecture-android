package com.example.clean_chitecture.data.source

import androidx.lifecycle.LiveData
import com.example.clean_chitecture.model.Movie

interface FavoriteDataSource {

    interface Local {

        suspend fun getFavoriteMovies(): MutableList<Movie>
    }

    interface Remote
}