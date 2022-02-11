package com.adhi.amovia.ui.category_items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.api.ApiConfig
import com.adhi.amovia.data.source.remote.response.FilmResponse
import com.adhi.amovia.data.source.remote.response.ListFilm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryItemsViewModel : ViewModel() {
    private val apiConfig = ApiConfig.getApiService()

    fun getCategoryItems(mediaType: String, category: String): LiveData<List<FilmResponse>> {
        val listItems = MutableLiveData<List<FilmResponse>>()
        val client = apiConfig.getFilm(mediaType, category)

        client.enqueue(object : Callback<ListFilm> {
            override fun onResponse(call: Call<ListFilm>, response: Response<ListFilm>) {
                listItems.value = response.body()?.results
            }

            override fun onFailure(call: Call<ListFilm>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return listItems
    }
}