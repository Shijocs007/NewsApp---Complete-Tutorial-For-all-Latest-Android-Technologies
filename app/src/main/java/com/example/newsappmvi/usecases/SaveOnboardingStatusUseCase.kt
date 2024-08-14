package com.example.newsappmvi.usecases

import com.example.newsappmvi.repository.DataStoreRepository
import javax.inject.Inject

class SaveOnboardingStatusUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(value: Boolean) {
        dataStoreRepository.saveOnBoardingStatus(status = value)
    }
}