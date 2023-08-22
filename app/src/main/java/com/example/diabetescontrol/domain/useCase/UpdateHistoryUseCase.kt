package com.example.diabetescontrol.domain.useCase

import com.example.diabetescontrol.domain.repository.HistoryRepository
import javax.inject.Inject

class UpdateHistoryUseCase @Inject constructor(private val repository: HistoryRepository) {

    suspend fun updateHistory(q: String) {
        repository.updateHistory(q)
    }

}