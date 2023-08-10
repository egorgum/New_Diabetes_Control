package com.example.diabetescontrol.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDto(
    @Json(name = "hints")
    val hints: List<ParsedDto>,
    @Json(name = "parsed")
    val parsed: List<ParsedDto>,
    @Json(name = "text")
    val text: String
)