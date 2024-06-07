package com.example.data.source.remote.api

import com.example.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("page") pageNumber: Int): MovieResponse
}