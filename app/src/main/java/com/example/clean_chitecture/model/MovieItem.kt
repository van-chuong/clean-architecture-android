package com.example.clean_chitecture.model

import android.content.res.Resources
import com.example.clean_chitecture.R
import com.example.clean_chitecture.model.base.ItemMapper
import com.example.clean_chitecture.model.base.ModelItem
import com.example.data.utils.toTimeLong
import com.example.data.utils.toTimeString
import com.example.domain.model.Movie

data class MovieItem(
    val id: Int,
    val name: String? = "",
    val voteCount: Int? = 0,
    val title: String? = "",
    val posterPath: String? = "",
    val backdropPath: String? = "",
    val overview: String? = "",
    val releaseDate: String? = ""
) : ModelItem()


class MovieItemMapper(
    private val resource: Resources
) : ItemMapper<Movie, MovieItem> {
    override fun mapToPresentation(model: Movie) = MovieItem(
        id = model.id,
        name = model.name,
        voteCount = model.voteCount,
        title = model.title,
        posterPath = model.posterPath,
        backdropPath = model.backdropPath,
        overview = model.overview,
        releaseDate = model.releaseDate?.toTimeString(resource.getString(R.string.format_yyyy_MM_dd))
    )

    override fun mapToDomain(modelItem: MovieItem) = Movie(
        id = modelItem.id,
        name = modelItem.name,
        voteCount = modelItem.voteCount,
        title = modelItem.title,
        posterPath = modelItem.posterPath,
        backdropPath = modelItem.backdropPath,
        overview = modelItem.overview,
        releaseDate = modelItem.releaseDate?.toTimeLong(resource.getString(R.string.format_yyyy_MM_dd))
    )
}