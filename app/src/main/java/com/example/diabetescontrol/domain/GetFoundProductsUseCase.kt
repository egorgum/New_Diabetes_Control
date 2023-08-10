package com.example.diabetescontrol.domain


class GetFoundProductsUseCase(private val searchingProductsRepository: SearchingProductsRepository) {
    suspend fun getFoundProducts(product: String): List<ProductInfo>{
        return searchingProductsRepository.getFoundProducts(product = product)
    }
}