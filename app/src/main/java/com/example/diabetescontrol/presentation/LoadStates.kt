package com.example.diabetescontrol.presentation

import com.example.diabetescontrol.R
import com.example.diabetescontrol.domain.ProductInfo

sealed  class LoadStates {
    data class Default(val textRes: Int = R.string.nutrientsInfo): LoadStates()
    data object Loading: LoadStates()
    data class Success(val products: List<ProductInfo>): LoadStates()
    data class Error(val errorMessage: String): LoadStates()
}