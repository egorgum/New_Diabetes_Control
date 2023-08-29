package com.example.diabetescontrol.presentation.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.diabetescontrol.presentation.screens.LoadStates

open class BaseNetworkViewModel(): ViewModel() {

    //States for Screens witch contact with NetWork

    protected var _stateOfLoading: MutableState<LoadStates> = mutableStateOf(
        LoadStates.Default)
    val stateOfLoading: State<LoadStates>
        get() = _stateOfLoading

}