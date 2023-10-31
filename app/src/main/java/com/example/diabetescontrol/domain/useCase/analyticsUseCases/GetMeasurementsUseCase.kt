package com.example.diabetescontrol.domain.useCase.analyticsUseCases

import com.example.diabetescontrol.domain.entities.DateOfMeasurements
import com.example.diabetescontrol.domain.repository.AnalyticsRepository
import javax.inject.Inject

class GetMeasurementsUseCase @Inject constructor(
    private val analyticsRepository: AnalyticsRepository
) {
    suspend fun getMeasurements(userId: String): List<DateOfMeasurements> {
        return analyticsRepository.getMeasurements(userId)
    }
}