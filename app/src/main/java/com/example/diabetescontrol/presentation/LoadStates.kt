package com.example.diabetescontrol.presentation

import com.example.diabetescontrol.domain.ProductInfo

sealed  class LoadStates {
    data object Loading: LoadStates()
    data class Success(val products: List<ProductInfo>): LoadStates()
    data class Error(val errorMessage: String): LoadStates()
}