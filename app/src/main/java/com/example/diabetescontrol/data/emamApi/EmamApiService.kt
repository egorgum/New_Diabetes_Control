package com.example.diabetescontrol.data.emamApi

import com.example.diabetescontrol.data.models.ProductDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EmamApiService {
    @GET("/api/food-database/v2/parser")//Get products from Seaching
    suspend fun parseProductInfo(
        @Query("app_id") appId: String = APP_ID,
        @Query("app_key") appKey: String = APP_KEY,
        @Query("ingr") ingr: String
    ): ProductDto

    companion object{
        //Emam API
        private const val APP_ID = "c36f23fa"
        private const val APP_KEY = "155898bbc7dd2ccba133d99ddc2e9a65"

    }
}