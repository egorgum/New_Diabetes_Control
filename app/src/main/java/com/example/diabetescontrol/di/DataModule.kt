package com.example.diabetescontrol.di

import android.content.Context
import com.example.diabetescontrol.data.storage.AppDb
import com.example.diabetescontrol.data.storage.HistoryDao
import com.example.diabetescontrol.data.emamApi.EmamApiFactory
import com.example.diabetescontrol.data.emamApi.EmamApiService
import com.example.diabetescontrol.data.mapper.AuthMapper
import com.example.diabetescontrol.data.mapper.HistoryMapper
import com.example.diabetescontrol.data.mapper.ProductMapper
import com.example.diabetescontrol.data.repocitory.AuthRepositoryImpl
import com.example.diabetescontrol.data.repocitory.HistoryRepositoryImpl
import com.example.diabetescontrol.data.repocitory.SearchingProductsRepositoryImpl
import com.example.diabetescontrol.domain.repository.AuthRepository
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

    //Network
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


    //Search history
    @Provides
    @Singleton
    fun provideHistoryRepository(
        mapper: HistoryMapper,
        dao: HistoryDao
    ): HistoryRepository {
        return HistoryRepositoryImpl(mapper, dao)
    }
    @Provides
    fun provideHistoryDao(@ApplicationContext context: Context): HistoryDao {
        return AppDb.getInstance(context).historyDao()
    }

    //AuthRepository
    @Provides
    @Singleton
    fun provideAuthRepository(mapper: AuthMapper): AuthRepository {
        return AuthRepositoryImpl(mapper)
    }

}