package com.example.diabetescontrol.data.mapper


import com.example.diabetescontrol.domain.entities.DateOfMeasurements
import com.example.diabetescontrol.domain.entities.GlucoseMeasurement
import com.google.firebase.database.DataSnapshot
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

class AnalyticsMapper @Inject constructor() {

    fun mapLongToDateString(time: Long): String {
        return SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).format(time)
    }

    fun mapLongToTimeString(time: Long): String {
        return SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(time)
    }

    fun mapDataSnapShotToListOfDatesOfMeasurements(snapshot: DataSnapshot): List<DateOfMeasurements> {
        val result = mutableListOf<DateOfMeasurements>()
        snapshot.children.forEach { date ->
            val measurements = mutableListOf<GlucoseMeasurement>()
            date.children.forEach {measurement ->
                measurements
                    .add(
                        GlucoseMeasurement(
                            time = measurement.key.toString(),
                            glucose = measurement.value.toString().toDouble()
                        )
                    )
            }
            result.add(
                DateOfMeasurements(
                    date = date.key.toString(),
                    measurements = measurements.reversed()
                )
            )
        }
        return result.reversed()
    }

    companion object {
        private const val TIME_FORMAT = "HH:mm"
        private const val DATE_FORMAT = "yyyy-MM-dd"
    }
}