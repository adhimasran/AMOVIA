package com.adhi.amovia.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class FilmResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("vote_average")
    val rating: Double,

    // Movie
    @field:SerializedName("title")
    val title: String? = null,

    // TV
    @field:SerializedName("name")
    val name: String? = null
)

data class ListFilm(
    @field:SerializedName("results")
    val results: List<FilmResponse>
)
