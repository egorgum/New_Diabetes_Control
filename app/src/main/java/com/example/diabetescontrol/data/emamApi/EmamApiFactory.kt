package com.example.diabetescontrol.data.emamApi

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object EmamApiFactory {

    private const val BASE_URL = "https://api.edamam.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create().asLenient())
        .build()
    val apiService: EmamApiService = retrofit.create(EmamApiService::class.java)
}