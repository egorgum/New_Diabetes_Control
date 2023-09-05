package com.example.diabetescontrol.domain.useCase.loginUseCases

import com.example.diabetescontrol.domain.repository.AuthRepository
import com.google.firebase.auth.AuthCredential
import javax.inject.Inject

class GoogleLoginUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend fun googleLogin(credential: AuthCredential, onComplete: (Boolean) -> Unit){
        repository.googleLogin(credential, onComplete)
    }
}