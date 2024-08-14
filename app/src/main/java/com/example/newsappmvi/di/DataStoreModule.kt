package com.example.newsappmvi.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsappmvi.repository.DataStoreRepository
import com.example.newsappmvi.repositoryimpl.DataStoreRepoImpl
import com.example.newsappmvi.usecases.FetchOnBoardingStatus
import com.example.newsappmvi.usecases.SaveOnboardingStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val DATASTORE_NAME = "news_app_datastore_preferences"

    private val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.dataStore
    }


}
