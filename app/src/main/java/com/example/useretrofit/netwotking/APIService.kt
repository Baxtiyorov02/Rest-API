package com.example.useretrofit.netwotking

import com.example.useretrofit.models.MarvelModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("demos/marvel/")
    fun getMarvels():Call<List<MarvelModel>>
}