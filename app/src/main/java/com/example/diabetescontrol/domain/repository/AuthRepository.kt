package com.example.diabetescontrol.domain.repository

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.AuthCredential

interface AuthRepository {
    fun hasUser():Boolean

    fun getUserId(): String

    suspend fun createUser(email: String, password: String, onComplete: (Boolean) -> Unit)

    suspend fun loginUser(email: String, password: String, onComplete: (Boolean) -> Unit)

    suspend fun googleLogin(credential: AuthCredential, onComplete: (Boolean) -> Unit)

     fun signOut(context: Context)

     fun getClient(context: Context): GoogleSignInClient
}