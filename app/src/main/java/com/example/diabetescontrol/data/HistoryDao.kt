package com.example.diabetescontrol.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Delete
    suspend fun deleteHistoryItem(query: HistoryDbModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHistoryItem(query: HistoryDbModel)

    @Query("SELECT * FROM history")
    fun getHistory(): Flow<List<HistoryDbModel>>

}