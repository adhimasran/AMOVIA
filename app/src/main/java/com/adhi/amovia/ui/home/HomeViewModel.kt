package com.adhi.amovia.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.api.ApiConfig
import com.adhi.amovia.data.source.remote.response.FilmResponse
import com.adhi.amovia.data.source.remote.response.ListFilm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val apiConfig = ApiConfig.getApiService()

    fun getUpcomingMovie(): LiveData<List<FilmResponse>> {
        val listMovie = MutableLiveData<List<FilmResponse>>()
        val client = apiConfig.getFilm("movie", "upcoming")

        client.enqueue(object : Callback<ListFilm> {
            override fun onResponse(call: Call<ListFilm>, response: Response<ListFilm>) {
                listMovie.value = response.body()?.results
            }

            override fun onFailure(call: Call<ListFilm>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return listMovie
    }

    fun getOnAirTv(): LiveData<List<FilmResponse>> {
        val listTv = MutableLiveData<List<FilmResponse>>()
        val client = apiConfig.getFilm("tv", "on_the_air")

        client.enqueue(object : Callback<ListFilm> {
            override fun onResponse(call: Call<ListFilm>, response: Response<ListFilm>) {
                listTv.value = response.body()?.results
            }

            override fun onFailure(call: Call<ListFilm>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return listTv
    }
}