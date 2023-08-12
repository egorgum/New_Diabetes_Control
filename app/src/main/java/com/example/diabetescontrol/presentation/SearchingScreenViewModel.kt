package com.example.diabetescontrol.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.data.emamApi.EmamApiFactory
import com.example.diabetescontrol.data.mapper.ProductMapper
import com.example.diabetescontrol.data.repocitory.SearchingProductsRepositoryImpl
import com.example.diabetescontrol.domain.GetFoundProductsUseCase
import kotlinx.coroutines.launch

class SearchingScreenViewModel:ViewModel(){

   var stateOfLoading: MutableState<LoadStates> = mutableStateOf(LoadStates.Default())
    private val mapper = ProductMapper()
    private val impl = SearchingProductsRepositoryImpl(mapper, EmamApiFactory.searchProduct )
    private val useCase = GetFoundProductsUseCase(impl)
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
                    LoadStates.Error(e.toString())
                }
        }
    }
}