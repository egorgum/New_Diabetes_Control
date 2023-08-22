package com.example.diabetescontrol.di

import android.content.Context
import com.example.diabetescontrol.data.AppDb
import com.example.diabetescontrol.data.HistoryDao
import com.example.diabetescontrol.data.emamApi.EmamApiFactory
import com.example.diabetescontrol.data.emamApi.EmamApiService
import com.example.diabetescontrol.data.mapper.HistoryMapper
import com.example.diabetescontrol.data.mapper.ProductMapper
import com.example.diabetescontrol.data.repocitory.HistoryRepositoryImpl
import com.example.diabetescontrol.data.repocitory.SearchingProductsRepositoryImpl
import com.example.diabetescontrol.domain.repository.HistoryRepository
import com.example.diabetescontrol.domain.repository.SearchingProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        ): SearchingProductsRepository {
        return SearchingProductsRepositoryImpl(mapper, apiService)
    }

    @Provides
    @Singleton
    fun provideApiService(): EmamApiService {
        return EmamApiFactory.apiService
    }


    @Provides
    @Singleton
    fun provideHistoryRepository(
        mapper: HistoryMapper,
        dao: HistoryDao
    ): HistoryRepository {
        return HistoryRepositoryImpl(mapper, dao)
    }
    @Provides
    fun provideHistoryDao(@ApplicationContext context: Context):HistoryDao{
        return AppDb.getInstance(context).historyDao()
    }

}