package com.example.domain.model

import com.example.domain.model.base.Model

data class Movie(
    val id: Int,
    val name: String? = "",
    val voteCount: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val backdropPath: String? = "",
    val overview: String? = "",
    val releaseDate: Long? = 0,
) : Model()