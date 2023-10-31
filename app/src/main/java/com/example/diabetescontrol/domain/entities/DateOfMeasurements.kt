package com.example.diabetescontrol.domain.entities

data class DateOfMeasurements(
    val date: String,
    val measurements: List<GlucoseMeasurement>
)
