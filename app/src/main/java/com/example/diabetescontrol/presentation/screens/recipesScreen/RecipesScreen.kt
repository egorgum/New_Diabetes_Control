package com.example.diabetescontrol.presentation.screens.recipesScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun RecipesScreen(){//viewModel: RecipesScreenViewModel) {

    //val state by remember { viewModel.stateOfLoading }

    Text(
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = "Recipes"
    )
}