package com.example.diabetescontrol.presentation.screens
sealed  class LoadStates {
    data object Default: LoadStates()
    data object Loading: LoadStates()
    data class Error(val errorMessage: String): LoadStates()
    data object Success: LoadStates()
}