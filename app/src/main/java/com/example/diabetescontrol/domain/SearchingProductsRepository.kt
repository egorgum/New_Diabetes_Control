package com.example.diabetescontrol.domain


interface SearchingProductsRepository {
    suspend fun getFoundProducts(product: String): List<ProductInfo>
}