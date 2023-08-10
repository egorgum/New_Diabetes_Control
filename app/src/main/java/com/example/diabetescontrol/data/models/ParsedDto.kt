package com.example.diabetescontrol.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ParsedDto(
    @Json(name = "food")
    val food: FoodDto
)