package com.example.diabetescontrol.domain.useCase

import com.example.diabetescontrol.domain.entities.ProductInfo
import com.example.diabetescontrol.domain.repository.SearchingProductsRepository
import javax.inject.Inject


class GetFoundProductsUseCase @Inject constructor(private val searchingProductsRepository: SearchingProductsRepository) {
    suspend fun getFoundProducts(product: String): List<ProductInfo>{
        return searchingProductsRepository.getFoundProducts(product = product)
    }
}