package com.example.diabetescontrol.domain.useCase

import android.util.Log
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.repository.RecipesRepository
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val repository: RecipesRepository) {

    suspend fun getRecipes(): List<RecipeInfo> {
        val result = repository.getRecipes()
        Log.d("LOL","Use Case result = $result")
        return result
    }

}