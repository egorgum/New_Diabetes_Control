package com.example.diabetescontrol.presentation.screens.recipesScreen

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.presentation.screens.ErrorScreenForRecipes

@Composable
fun RecipesScreen(){//viewModel: RecipesScreenViewModel) {

    //val state by remember { viewModel.stateOfLoading }
    var oneItem = RecipeInfo(
        title = "pancake",
        image = "https://blog.jetbrains.com/wp-content/uploads/2020/11/light.png",
        recipe = "DFHGGDFHDFGHDFGDFGSDFGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"
    )
    val list = listOf<RecipeInfo>(oneItem)
    //ListOfRecipeItems(items = list)
    ErrorScreenForRecipes(errorMessage = "Ошибка сети, повторите позже") {
        Log.d("LOL","Update")
    }


}