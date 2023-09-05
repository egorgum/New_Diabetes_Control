package com.example.diabetescontrol.domain.useCase.loginUseCases

import com.example.diabetescontrol.domain.repository.AuthRepository
import javax.inject.Inject

class GetUserIdUseCase @Inject constructor(private val repository: AuthRepository) {
    fun getUserId():String {
        return repository.getUserId()
    }
}