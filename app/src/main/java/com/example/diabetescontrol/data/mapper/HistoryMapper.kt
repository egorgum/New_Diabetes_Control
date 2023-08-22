package com.example.diabetescontrol.data.mapper

import com.example.diabetescontrol.data.storage.HistoryDbModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryMapper @Inject constructor(){

    fun mapDbModelsFlowToStringsFlow(models: Flow<List<HistoryDbModel>>): Flow<List<String>> {
        return models.map {
            //Reverse for history sequence
            it.reversed().map { item ->
                item.query
            }
        }
    }

    fun mapStrToDbModel(q: String) = HistoryDbModel(q)

}