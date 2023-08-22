package com.example.diabetescontrol.data.repocitory


import com.example.diabetescontrol.data.emamApi.EmamApiService
import com.example.diabetescontrol.data.mapper.ProductMapper
import com.example.diabetescontrol.domain.entities.ProductInfo
import com.example.diabetescontrol.domain.repository.SearchingProductsRepository
import javax.inject.Inject


class SearchingProductsRepositoryImpl @Inject constructor(
    private val mapper: ProductMapper,
    private val apiService: EmamApiService,
) : SearchingProductsRepository {

    override suspend fun getFoundProducts(product: String): List<ProductInfo> {
        return mapper.mapDtoToProductInfoList(apiService.parseProductInfo(ingr = product))
    }
}