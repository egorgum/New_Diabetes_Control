package com.example.diabetescontrol.presentation.viewModels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.domain.entities.ProductInfo
import com.example.diabetescontrol.domain.useCase.GetFoundProductsUseCase
import com.example.diabetescontrol.presentation.screens.LoadStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(private val useCase: GetFoundProductsUseCase):BaseNetworkViewModel(){

    private var _products: List<ProductInfo> = emptyList()
    val products
        get() = _products

    fun getProducts(product: String){
        viewModelScope.launch {
            _stateOfLoading.value = LoadStates.Loading
            _stateOfLoading.value =
               try {
                   _products = useCase.getFoundProducts(product)
                   LoadStates.Success
               }
                catch (e: Exception) {
                    Log.e("SearchScreen", "Error: $e")
                    LoadStates.Error(e.message.toString())
                }
        }
    }


    fun backToDefaultState(){
        _stateOfLoading.value = LoadStates.Default
    }

}