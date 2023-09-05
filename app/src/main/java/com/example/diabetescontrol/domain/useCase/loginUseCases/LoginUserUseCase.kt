package com.example.diabetescontrol.domain.useCase.loginUseCases

import com.example.diabetescontrol.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend fun loginUser(email: String, password: String, onComplete: (Boolean) -> Unit){
        repository.loginUser(email, password, onComplete)
    }
}