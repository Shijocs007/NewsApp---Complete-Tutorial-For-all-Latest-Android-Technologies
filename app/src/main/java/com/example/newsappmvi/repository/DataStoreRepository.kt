package com.example.newsappmvi.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun saveOnBoardingStatus(status : Boolean)

    fun getOnBoardingStatus() : Flow<Boolean>
}