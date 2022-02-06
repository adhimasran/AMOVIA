package com.adhi.amovia.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("vote_average")
    val rating: Double
)

data class ListTv(
    @field:SerializedName("results")
    val results: List<TvResponse>
)
