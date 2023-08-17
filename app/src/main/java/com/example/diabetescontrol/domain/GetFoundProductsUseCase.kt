package com.example.diabetescontrol.domain

import javax.inject.Inject


class GetFoundProductsUseCase @Inject constructor(private val searchingProductsRepository: SearchingProductsRepository) {
    suspend fun getFoundProducts(product: String): List<ProductInfo>{
        return searchingProductsRepository.getFoundProducts(product = product)
    }
}