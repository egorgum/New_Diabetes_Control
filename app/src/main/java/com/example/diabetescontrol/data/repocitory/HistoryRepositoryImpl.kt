package com.example.diabetescontrol.data.repocitory

import com.example.diabetescontrol.data.HistoryDao
import com.example.diabetescontrol.data.mapper.HistoryMapper
import com.example.diabetescontrol.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val mapper: HistoryMapper,
    private val dao: HistoryDao
):HistoryRepository {

    override suspend fun getHistory(): Flow<List<String>> {
        return mapper.mapDbModelsFlowToStringsFlow(dao.getHistory())
    }

    override suspend fun deleteHistoryItem(q: String) {
        dao.deleteHistoryItem(mapper.mapStrToDbModel(q))
    }

    override suspend fun updateHistory(q: String) {
        deleteHistoryItem(q)
        dao.addHistoryItem(mapper.mapStrToDbModel(q))
    }


}