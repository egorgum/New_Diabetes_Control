package com.example.diabetescontrol.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NutrientsDto(
    @Json(name = "CHOCDF")
    val CHOCDF: Double,//carbohydrates
    @Json(name = "ENERC_KCAL")
    val ENERC_KCAL: Double,//energy
    @Json(name = "FAT")
    val FAT: Double,//fats
    @Json(name = "FIBTG")
    val FIBTG: Double?,
    @Json(name = "PROCNT")
    val PROCNT: Double//proteins
)