package com.example.diabetescontrol.domain.repository

import com.example.diabetescontrol.domain.entities.DateOfMeasurements

interface AnalyticsRepository {
    suspend fun setMeasurement(glucose: Double, userId: String)
    suspend fun getMeasurements(userId: String): List<DateOfMeasurements>
}