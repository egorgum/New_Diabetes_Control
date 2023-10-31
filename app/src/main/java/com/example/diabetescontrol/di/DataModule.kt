package com.example.diabetescontrol.di

import android.content.Context
import com.example.diabetescontrol.data.storage.AppDb
import com.example.diabetescontrol.data.storage.HistoryDao
import com.example.diabetescontrol.data.emamApi.EmamApiFactory
import com.example.diabetescontrol.data.emamApi.EmamApiService
import com.example.diabetescontrol.data.mapper.AnalyticsMapper
import com.example.diabetescontrol.data.mapper.AuthMapper
import com.example.diabetescontrol.data.mapper.HistoryMapper
import com.example.diabetescontrol.data.mapper.ProductMapper
import com.example.diabetescontrol.data.mapper.RecipesMapper
import com.example.diabetescontrol.data.repocitory.AnalyticsRepositoryImpl
import com.example.diabetescontrol.data.repocitory.AuthRepositoryImpl
import com.example.diabetescontrol.data.repocitory.HistoryRepositoryImpl
import com.example.diabetescontrol.data.repocitory.RecipesRepositoryImpl
import com.example.diabetescontrol.data.repocitory.SearchingProductsRepositoryImpl
import com.example.diabetescontrol.domain.repository.AnalyticsRepository
import com.example.diabetescontrol.domain.repository.AuthRepository
import com.example.diabetescontrol.domain.repository.HistoryRepository
import com.example.diabetescontrol.domain.repository.RecipesRepository
import com.example.diabetescontrol.domain.repository.SearchingProductsRepository
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
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

    //Recipes
    @Provides
    @Singleton
    fun provideRecipeRepository(
        mapper: RecipesMapper,
        firebaseDatabase: FirebaseDatabase): RecipesRepository {
        return RecipesRepositoryImpl(firebaseDatabase, mapper)
    }

    //Measurements
    @Provides
    @Singleton
    fun provideAnalysisRepository(
        mapper: AnalyticsMapper,
        firebaseDatabase: FirebaseDatabase): AnalyticsRepository {
        return AnalyticsRepositoryImpl(firebaseDatabase, mapper)
    }

    //Firebase Database
    @Provides
    @Singleton
    fun provideFirebaseDataBase(): FirebaseDatabase {
        Firebase.database.setPersistenceEnabled(false)
        return Firebase.database
    }

}