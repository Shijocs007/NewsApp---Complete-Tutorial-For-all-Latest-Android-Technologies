package com.example.newsappmvi.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.newsappmvi.repository.DataStoreRepository
import com.example.newsappmvi.repositoryimpl.DataStoreRepoImpl
import com.example.newsappmvi.usecases.FetchOnBoardingStatus
import com.example.newsappmvi.usecases.SaveOnboardingStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSaveOnboardingUseCase(
        repository: DataStoreRepository
    ) = SaveOnboardingStatusUseCase(dataStoreRepository = repository)

    @Provides
    @Singleton
    fun provideFetchOnboardingUseCase(
        repository: DataStoreRepository
    ) = FetchOnBoardingStatus(dataStoreRepository = repository)
}