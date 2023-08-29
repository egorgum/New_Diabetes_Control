package com.example.diabetescontrol.presentation.uiComponents.recipesScreenList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.diabetescontrol.domain.entities.RecipeInfo

@Composable
fun ListOfRecipeItems(items: List<RecipeInfo>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items.forEach {
            item {
                OneRecipeItem(item = it)
            }
        }
    }
}