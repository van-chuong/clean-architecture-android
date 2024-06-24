package com.example.clean_chitecture.data.source.remote.api

import com.example.clean_chitecture.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("page") pageNumber: Int): MoviesResponse
}