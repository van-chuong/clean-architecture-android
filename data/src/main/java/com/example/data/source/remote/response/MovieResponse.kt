package com.example.data.source.remote.response

import com.example.data.model.MovieEntity
import com.google.gson.annotations.SerializedName

open class MovieResponse(
    @SerializedName("total_pages")
    var mTotalPages: Int? = 1,

    @SerializedName("results")
    var mListMovie: ArrayList<MovieEntity> = arrayListOf()
)