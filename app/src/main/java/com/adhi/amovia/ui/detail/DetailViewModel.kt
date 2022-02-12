package com.adhi.amovia.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.api.ApiConfig
import com.adhi.amovia.data.source.remote.response.DetailFilmResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    fun getDetailFilm(mediaType: String, id: Int): LiveData<DetailFilmResponse> {
        val film = MutableLiveData<DetailFilmResponse>()
        val client = ApiConfig.getApiService().getDetailFilm(mediaType, id)

        client.enqueue(object : Callback<DetailFilmResponse> {
            override fun onResponse(
                call: Call<DetailFilmResponse>,
                response: Response<DetailFilmResponse>
            ) {
                film.value = response.body()
            }

            override fun onFailure(call: Call<DetailFilmResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return film
    }
}