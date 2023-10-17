package com.example.diabetescontrol.data.repocitory

import com.example.diabetescontrol.data.mapper.RecipesMapper
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.repository.RecipesRepository
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
    private val mapper: RecipesMapper
): RecipesRepository {
    override suspend fun getRecipes(): List<RecipeInfo> {
        //Ger data from firebase realtime database
        val snap = try {
            firebaseDatabase.getReference(RECIPE_TABLE_NAME).get().await()
        } catch (e: Exception) {
           throw RuntimeException(e)
        }
        //Map data
        return mapper.mapDataSnapShotToListOfRecipes(snap)
    }
    companion object {
        private const val RECIPE_TABLE_NAME = "Recipes"
    }
}