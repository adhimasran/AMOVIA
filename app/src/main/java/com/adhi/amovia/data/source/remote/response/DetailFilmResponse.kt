package com.adhi.amovia.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailFilmResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("tagline")
    val tagline: String,

    @field:SerializedName("vote_average")
    val rating: Double,

    @field:SerializedName("vote_count")
    val ratingCount: Int,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("genres")
    val genres: List<GenreItems>,

    // Movie
    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("release_date")
    val release: String? = null,

    @field:SerializedName("runtime")
    val runtime: Int = 0,

    // TV
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("first_air_date")
    val firstAir: String? = null,

    @field:SerializedName("episode_run_time")
    val episodeRuntime: List<Int>? = null

)
