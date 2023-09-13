package com.example.diabetescontrol.domain.repository

import com.example.diabetescontrol.domain.entities.RecipeInfo

interface RecipesRepository {
    suspend fun getRecipes(): List<RecipeInfo>
}