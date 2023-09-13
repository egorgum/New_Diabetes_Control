package com.example.diabetescontrol.data.repocitory

import android.util.Log
import com.example.diabetescontrol.data.mapper.RecipesMapper
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.repository.RecipesRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val mapper: RecipesMapper
): RecipesRepository {
    override suspend fun getRecipes(): List<RecipeInfo> {
        var result: List<RecipeInfo> = emptyList()
        fireStore.collection(RECIPE_TABLE_NAME).get()
            .addOnSuccessListener {snap ->
                Log.d("LOL","Snap:")
                result = mapper.mapQuerySnapShotRecipesToListOfRecipes(snap)
            }
            .addOnFailureListener {
                throw RuntimeException(it)
            }.await()
        Log.d("LOL","Impl result = $result")
        return result
    }
    companion object {
        private const val RECIPE_TABLE_NAME = "Recipes"

    }
}