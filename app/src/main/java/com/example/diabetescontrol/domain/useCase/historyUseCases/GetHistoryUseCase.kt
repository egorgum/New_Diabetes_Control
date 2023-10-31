package com.example.diabetescontrol.domain.useCase.historyUseCases

import com.example.diabetescontrol.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val repo: HistoryRepository) {

    suspend fun getHistory(): Flow<List<String>> {
        return repo.getHistory()
    }

}