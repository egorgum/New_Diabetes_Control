package com.example.diabetescontrol.domain.repository

import com.example.diabetescontrol.domain.entities.ProductInfo


interface SearchingProductsRepository {
    suspend fun getFoundProducts(product: String): List<ProductInfo>
}