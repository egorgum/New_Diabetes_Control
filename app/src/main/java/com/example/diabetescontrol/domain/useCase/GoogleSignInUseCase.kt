package com.example.diabetescontrol.domain.useCase

import android.content.Intent
import com.example.diabetescontrol.presentation.sign_in.SignInResult
import com.example.diabetescontrol.domain.repository.AuthRepository

class GoogleSignInUseCase(private val repository: AuthRepository) {

    suspend fun googleSignIn(intent: Intent): SignInResult {
        return repository.googleSignIn(intent)
    }

}