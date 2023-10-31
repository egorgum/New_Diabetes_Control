package com.example.diabetescontrol.data.repocitory

import android.util.Log
import com.example.diabetescontrol.data.mapper.AnalyticsMapper
import com.example.diabetescontrol.domain.entities.DateOfMeasurements
import com.example.diabetescontrol.domain.repository.AnalyticsRepository
import com.google.firebase.Timestamp
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class AnalyticsRepositoryImpl(
    firebaseDatabase: FirebaseDatabase,
    private val mapper: AnalyticsMapper
): AnalyticsRepository {
    private val ref = firebaseDatabase.getReference(USERS_TABLE_NAME)


    override suspend fun setMeasurement (
        glucose: Double,
        userId: String) {
        ref
            .child(userId)
            .child(mapper.mapLongToDateString(now()))
            .child(mapper.mapLongToTimeString(now()))
            .setValue(glucose).await()
    }
    private fun now(): Long {
        return Timestamp.now().seconds * MILLISECONDS_IN_SECOND
    }

    override suspend fun getMeasurements(userId: String): List<DateOfMeasurements> {
        //Ger data from firebase realtime database
        val snap = try {
            ref.child(userId).get().await()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
        Log.d("LOL", "Snap A: $snap")
        //Map data
        return mapper.mapDataSnapShotToListOfDatesOfMeasurements(snap)
    }


    companion object {
        private const val USERS_TABLE_NAME = "Users"
        private const val MILLISECONDS_IN_SECOND = 1000
    }
}