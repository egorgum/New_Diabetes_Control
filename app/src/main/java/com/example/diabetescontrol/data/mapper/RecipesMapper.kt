package com.example.diabetescontrol.data.mapper

import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

class RecipesMapper @Inject constructor() {
    fun mapDataSnapShotToListOfRecipes(snap: DataSnapshot): List<RecipeInfo>{
        val result = mutableListOf<RecipeInfo>()
        snap.children.forEach {
            result.add(
                RecipeInfo(
                    title = it.child(TITLE_KEY).value.toString(),
                    image = it.child(IMAGE_KEY).value.toString(),
                    recipe = it.child(RECIPE_KEY).value.toString(),
                )
            )
        }
        return result
    }
    companion object {
        private const val TITLE_KEY = "title"
        private const val IMAGE_KEY = "image"
        private const val RECIPE_KEY = "recipe"
    }
}