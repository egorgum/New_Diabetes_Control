package com.example.diabetescontrol.data.repocitory

import com.example.diabetescontrol.domain.entities.RecipeInfo
import com.example.diabetescontrol.domain.repository.RecipesRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RecipesRepositoryImpl(
    private val fireStore: FirebaseFirestore,
//    private val mapper:
){//: RecipesRepository {
//    override fun getRecipes(): List<RecipeInfo> {
//        fireStore.collection("Recipes").get()
//            .addOnSuccessListener {result ->
//                for (document in result){
//                    val a  =document.data
//                }
//            }
//    }
}