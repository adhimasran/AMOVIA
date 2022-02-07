package com.adhi.amovia.data.api

import com.adhi.amovia.data.source.remote.response.ListFilm
import com.adhi.amovia.utils.Constants.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{media_type}/{category}?api_key=$API_KEY")
    fun getFilm(
        @Path("media_type") mediaType: String,
        @Path("category") category: Int
    ): Call<ListFilm>
}