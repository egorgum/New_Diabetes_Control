package com.example.diabetescontrol.data.mapper

import android.util.Log
import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class RecipesMapper @Inject constructor() {
    fun mapQuerySnapShotRecipesToListOfRecipes(snap: QuerySnapshot): List<RecipeInfo>{
        val result = mutableListOf<RecipeInfo>()
        for (doc in snap){
            result.add(doc.toObject(RecipeInfo::class.java))
        }
        Log.d("LOL","Mapper result = $result")
        return result
    }
}