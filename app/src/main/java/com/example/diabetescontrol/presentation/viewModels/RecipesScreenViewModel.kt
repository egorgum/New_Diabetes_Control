package com.example.diabetescontrol.presentation.viewModels

import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.useCase.GetRecipesUseCase

class RecipesScreenViewModel(private val getRecipesUseCase: GetRecipesUseCase) : BaseNetworkViewModel() {

    private var _recipes: List<RecipeInfo> = emptyList()
    val recipes: List<RecipeInfo>
        get() = _recipes

    fun getRecipes(){
        _recipes = getRecipesUseCase.getRecipes()
    }

}