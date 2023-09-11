package com.example.diabetescontrol.domain.useCase

import com.example.diabetescontrol.domain.repository.HistoryRepository
import javax.inject.Inject

class DeleteAllHistoryUseCase @Inject constructor(private val repository: HistoryRepository) {
    suspend fun deleteAllHistory(){
        repository.deleteAllItems()
    }
}