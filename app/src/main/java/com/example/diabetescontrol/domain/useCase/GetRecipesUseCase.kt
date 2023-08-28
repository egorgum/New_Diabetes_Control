package com.example.diabetescontrol.domain.useCase

import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.repository.RecipesRepository

class GetRecipesUseCase(private val repository: RecipesRepository) {

    fun getRecipes(): List<RecipeInfo> {
        return repository.getRecipes()
    }

}