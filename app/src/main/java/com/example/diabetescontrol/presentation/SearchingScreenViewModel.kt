package com.example.diabetescontrol.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.domain.useCase.GetFoundProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchingScreenViewModel @Inject constructor(private val useCase: GetFoundProductsUseCase):ViewModel(){

    var stateOfLoading: MutableState<LoadStates> = mutableStateOf(LoadStates.Default())

    fun getProducts(product: String){
        viewModelScope.launch {
            stateOfLoading.value = LoadStates.Loading
            stateOfLoading.value =
               try {
                   val a = useCase.getFoundProducts(product)
                   Log.d("LOL", a.toString())
                   LoadStates.Success(a)
               }
                catch (e: Exception) {
                    Log.e("SearchScreen", "Error: $e")
                    LoadStates.Error(e.message.toString())
                }
        }
    }

    fun backToDefaultState(){
        stateOfLoading.value = LoadStates.Default()
    }
}