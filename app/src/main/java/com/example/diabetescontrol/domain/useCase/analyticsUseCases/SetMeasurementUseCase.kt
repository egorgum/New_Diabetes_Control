package com.example.diabetescontrol.domain.useCase.analyticsUseCases

import com.example.diabetescontrol.domain.repository.AnalyticsRepository
import javax.inject.Inject

class SetMeasurementUseCase@Inject constructor(
    private val analyticsRepository: AnalyticsRepository
) {
    suspend fun setMeasurement(glucose: Double, userId: String) {
        analyticsRepository.setMeasurement(glucose, userId)
    }
}