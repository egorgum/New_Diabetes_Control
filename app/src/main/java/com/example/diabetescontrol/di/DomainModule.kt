package com.example.diabetescontrol.di

import com.example.diabetescontrol.domain.repository.HistoryRepository
import com.example.diabetescontrol.domain.useCase.GetFoundProductsUseCase
import com.example.diabetescontrol.domain.repository.SearchingProductsRepository
import com.example.diabetescontrol.domain.useCase.DeleteHistoryItemUseCase
import com.example.diabetescontrol.domain.useCase.GetHistoryUseCase
import com.example.diabetescontrol.domain.useCase.UpdateHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    @ViewModelScoped
    fun provideGetFoundProductsUseCase(repository: SearchingProductsRepository): GetFoundProductsUseCase {
        return GetFoundProductsUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteHistoryItemUseCase(repository: HistoryRepository): DeleteHistoryItemUseCase {
        return DeleteHistoryItemUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetHistoryUseCase(repository: HistoryRepository): GetHistoryUseCase {
        return GetHistoryUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideUpdateHistoryUseCase(repository: HistoryRepository): UpdateHistoryUseCase {
        return UpdateHistoryUseCase(repository)
    }



}