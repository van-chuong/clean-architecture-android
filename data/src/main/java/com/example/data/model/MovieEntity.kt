package com.example.data.model

import androidx.room.Entity
import com.example.data.ConstantData
import com.example.data.model.base.EntityMapper
import com.example.data.model.base.ModelEntity
import com.example.data.utils.toTimeLong
import com.example.data.utils.toTimeString
import com.example.domain.model.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie", primaryKeys = ["id"])
data class MovieEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val name: String? = "",
    @SerializedName("vote_count") val voteCount: Int? = 0,
    @SerializedName("original_title") val title: String? = "",
    @SerializedName("poster_path") val posterPath: String? = "",
    @SerializedName("backdrop_path") val backdropPath: String? = "",
    @SerializedName("overview") val overview: String? = "",
    @SerializedName("release_date") val releaseDate: String? = "",
) : ModelEntity()

class MovieEntityMapper : EntityMapper<Movie, MovieEntity> {

    override fun mapToDomain(modelEntity: MovieEntity) = Movie(
        id = modelEntity.id,
        name = modelEntity.name,
        voteCount = modelEntity.voteCount,
        title = modelEntity.title,
        posterPath = modelEntity.posterPath,
        backdropPath = modelEntity.backdropPath,
        overview = modelEntity.overview,
        releaseDate = modelEntity.releaseDate?.toTimeLong(ConstantData.FORMAT_YYYY_MM_DD)
    )

    override fun mapToEntity(model: Movie) = MovieEntity(
        id = model.id,
        name = model.name,
        voteCount = model.voteCount,
        title = model.title,
        posterPath = model.posterPath,
        backdropPath = model.backdropPath,
        overview = model.overview,
        releaseDate = model.releaseDate?.toTimeString(ConstantData.FORMAT_YYYY_MM_DD)
    )
}
