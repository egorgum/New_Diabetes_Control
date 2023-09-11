package com.example.diabetescontrol.domain.repository

import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun getHistory(): Flow<List<String>>

    suspend fun updateHistory(q:String)

    suspend fun  deleteHistoryItem(q:String)
    suspend fun deleteAllItems()

}