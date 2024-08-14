package com.example.newsappmvi.di

import com.example.newsappmvi.repository.DataStoreRepository
import com.example.newsappmvi.repositoryimpl.DataStoreRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepositoryImpl: DataStoreRepoImpl): DataStoreRepository

}