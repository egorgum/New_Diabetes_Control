package com.example.diabetescontrol.data.repocitory

import com.example.diabetescontrol.data.storage.HistoryDao
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

    override suspend fun deleteAllItems() {
        dao.deleteAllHistoryItems()
    }
    //Deleting to avoid repeating items and after that we add item in the search history
    override suspend fun updateHistory(q: String) {
        deleteHistoryItem(q)
        dao.addHistoryItem(mapper.mapStrToDbModel(q))
    }


}