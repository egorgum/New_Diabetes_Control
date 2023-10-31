package com.example.diabetescontrol.presentation.screens.recipesScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.diabetescontrol.presentation.screens.ErrorScreenForRecipes
import com.example.diabetescontrol.presentation.screens.LoadStates
import com.example.diabetescontrol.presentation.uiComponents.LoadingSample
import com.example.diabetescontrol.presentation.uiComponents.recipesScreenList.ListOfRecipeItems
import com.example.diabetescontrol.presentation.viewModels.RecipesScreenViewModel

@Composable
fun RecipesScreen(viewModel: RecipesScreenViewModel) {
    val state by remember { viewModel.stateOfLoading }

    Column {
        when (state){
            is LoadStates.Loading -> LoadingSample()
            is LoadStates.Error -> {
                ErrorScreenForRecipes(errorMessage = (state as LoadStates.Error).errorMessage){//"Ошибка сети, повторите позже") {
                    viewModel.getRecipes()
                }
            }
            is LoadStates.Success -> {
                ListOfRecipeItems(items = viewModel.recipes)
            }
            is LoadStates.Default -> {}
        }
    }
}