package com.example.diabetescontrol.domain.useCase.loginUseCases

import com.example.diabetescontrol.domain.entities.AccountInfo
import com.example.diabetescontrol.domain.repository.AuthRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val repository: AuthRepository) {
    fun getUser():AccountInfo {
        return repository.getUser()
    }
}