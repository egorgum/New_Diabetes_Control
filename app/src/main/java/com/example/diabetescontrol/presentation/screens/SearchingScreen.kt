package com.example.diabetescontrol.presentation.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource

import com.example.diabetescontrol.presentation.LoadStates
import com.example.diabetescontrol.presentation.uiComponents.LoadingSample
import com.example.diabetescontrol.presentation.SearchingScreenViewModel
import com.example.diabetescontrol.presentation.uiComponents.TextInCenterSample
import com.example.diabetescontrol.presentation.uiComponents.list.ListOfItems
import com.example.diabetescontrol.presentation.uiComponents.searchBar.SearchBarSample

@Composable
fun SearchingScreen(viewModel: SearchingScreenViewModel) {

    val state by remember{ viewModel.stateOfLoading }

    Column() {

        SearchBarSample { q ->  viewModel.getProducts(q)}

        when(state){
            is LoadStates.Default ->
                TextInCenterSample(stringResource((state as LoadStates.Default).textRes))

            is LoadStates.Success ->
                ListOfItems((state as LoadStates.Success).products)

            is LoadStates.Error ->
                TextInCenterSample((state as LoadStates.Error).errorMessage)

            is LoadStates.Loading ->
                LoadingSample()
        }
    }
}
