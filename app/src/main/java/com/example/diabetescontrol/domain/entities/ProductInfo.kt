package com.example.diabetescontrol.domain.entities

data class ProductInfo(
    val image: String?,
    val label: String,
    val carbohydrates: Double,
    val energy: Double,
    val fats: Double,
    val proteins: Double
)