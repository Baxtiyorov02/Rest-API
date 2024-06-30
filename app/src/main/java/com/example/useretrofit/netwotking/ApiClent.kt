package com.example.useretrofit.netwotking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClent {


    const val BASE_URL = "https://www.simplifiedcoding.net/"

    fun getRetrofit(): Retrofit {


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}