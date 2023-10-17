package com.example.diabetescontrol.presentation.screens.searchScreen
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.diabetescontrol.R
import com.example.diabetescontrol.presentation.screens.LoadStates

import com.example.diabetescontrol.presentation.uiComponents.LoadingSample
import com.example.diabetescontrol.presentation.uiComponents.TextInCenterSample
import com.example.diabetescontrol.presentation.uiComponents.searchScreenList.ListOfProductItems
import com.example.diabetescontrol.presentation.uiComponents.searchBar.SearchBarSample
import com.example.diabetescontrol.presentation.viewModels.SearchScreenViewModel

@Composable
fun SearchScreen(viewModel: SearchScreenViewModel) {

    val state by remember{ viewModel.stateOfLoading }

    BackHandler(enabled = state != LoadStates.Default) {
        viewModel.backToDefaultState()
    }

    Column() {
        
        SearchBarSample { q ->  viewModel.getProducts(q)}

        when(state){
            is LoadStates.Default ->

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center) {
                    TextInCenterSample(stringResource(R.string.nutrients_info))
                }

            is LoadStates.Success ->
                ListOfProductItems(viewModel.products)

            is LoadStates.Error ->
               TextInCenterSample((state as LoadStates.Error).errorMessage)

            is LoadStates.Loading ->
                LoadingSample()
        }
    }
}
