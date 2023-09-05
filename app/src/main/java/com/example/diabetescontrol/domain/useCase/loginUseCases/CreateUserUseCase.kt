package com.example.diabetescontrol.domain.useCase.loginUseCases

import com.example.diabetescontrol.domain.repository.AuthRepository
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend fun createUser(email: String, password: String, onComplete: (Boolean) -> Unit){
        repository.createUser(email, password, onComplete)
    }
}