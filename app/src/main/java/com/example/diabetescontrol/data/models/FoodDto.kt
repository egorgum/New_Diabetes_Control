package com.example.diabetescontrol.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FoodDto(
    @Json(name = "category")
    val category: String?,
    @Json(name = "categoryLabel")
    val categoryLabel: String?,
    @Json(name = "foodId")
    val foodId: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "knownAs")
    val knownAs: String?,
    @Json(name = "label")
    val label: String,
    @Json(name = "nutrients")
    val nutrients: NutrientsDto
)