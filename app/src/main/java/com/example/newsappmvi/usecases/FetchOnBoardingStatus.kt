package com.example.newsappmvi.usecases

import com.example.newsappmvi.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchOnBoardingStatus @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    operator fun invoke(): Flow<Boolean> {
        return dataStoreRepository.getOnBoardingStatus()
    }
}