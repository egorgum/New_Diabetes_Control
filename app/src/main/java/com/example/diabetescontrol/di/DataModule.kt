package com.example.diabetescontrol.di

import com.example.diabetescontrol.data.emamApi.EmamApiFactory
import com.example.diabetescontrol.data.emamApi.EmamApiService
import com.example.diabetescontrol.data.mapper.ProductMapper
import com.example.diabetescontrol.data.repocitory.SearchingProductsRepositoryImpl
import com.example.diabetescontrol.domain.SearchingProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Provides
    @Singleton
    fun provideSearchingProductsRepository(
        mapper: ProductMapper,
        apiService: EmamApiService
        ): SearchingProductsRepository{
        return SearchingProductsRepositoryImpl(mapper, apiService)
    }

    @Provides
    @Singleton
    fun provideApiService(): EmamApiService {
        return EmamApiFactory.apiService
    }

}