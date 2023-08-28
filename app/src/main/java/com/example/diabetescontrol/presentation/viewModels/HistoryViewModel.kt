package com.example.diabetescontrol.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.domain.useCase.DeleteHistoryItemUseCase
import com.example.diabetescontrol.domain.useCase.GetHistoryUseCase
import com.example.diabetescontrol.domain.useCase.UpdateHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase,
    private val updateHistoryUseCase: UpdateHistoryUseCase,
    private val deleteHistoryItemUseCase: DeleteHistoryItemUseCase
): ViewModel() {

    private var _history: Flow<List<String>>? = null
    val history: Flow<List<String>>
        get() = _history!!

    init {
        getHistory()
    }

    private fun getHistory(){
        viewModelScope.launch {
            _history = getHistoryUseCase.getHistory()
        }
    }

    fun deleteHistoryItem(q: String){
        viewModelScope.launch {
            deleteHistoryItemUseCase.deleteHistoryItem(q)
        }
    }

    fun updateHistory(q: String){
        viewModelScope.launch {
            updateHistoryUseCase.updateHistory(q)
        }
    }


}