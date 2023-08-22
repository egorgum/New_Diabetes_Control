package com.example.diabetescontrol.domain.useCase

import com.example.diabetescontrol.domain.repository.HistoryRepository
import javax.inject.Inject

class DeleteHistoryItemUseCase @Inject constructor(private val repository: HistoryRepository) {
    suspend fun deleteHistoryItem(q: String){
        repository.deleteHistoryItem(q)
    }
}