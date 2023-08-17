package com.example.diabetescontrol.di

import com.example.diabetescontrol.domain.GetFoundProductsUseCase
import com.example.diabetescontrol.domain.SearchingProductsRepository
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
    fun provideGetFoundProductsUseCase(repository: SearchingProductsRepository): GetFoundProductsUseCase{
        return GetFoundProductsUseCase(repository)
    }

}