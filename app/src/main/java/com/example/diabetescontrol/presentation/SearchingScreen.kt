package com.example.diabetescontrol.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun SearchingScreen() {

    val viewModel = MainViewModel()
    viewModel.getProducts("banana")
    val state by remember {viewModel.stateOfLoading}
    when(state){
        is LoadStates.Success -> {
            val item = (state as LoadStates.Success).products
            ListOfItems(items = item)
            Log.d(TAG, item.toString())
        }
        is LoadStates.Error -> Log.d("LOL", (state as LoadStates.Error).errorMessage)
        is LoadStates.Loading -> {Log.d("LOL", "Loading")}
    }


}