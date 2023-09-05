package com.example.diabetescontrol.domain.useCase.loginUseCases

import com.example.diabetescontrol.domain.repository.AuthRepository
import javax.inject.Inject

class HasUserUseCase @Inject constructor(private val repository: AuthRepository) {

    fun hasUser():Boolean{
        return repository.hasUser()
    }

}