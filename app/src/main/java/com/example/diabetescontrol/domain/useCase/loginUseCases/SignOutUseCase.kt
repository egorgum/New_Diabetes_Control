package com.example.diabetescontrol.domain.useCase.loginUseCases

import android.content.Context
import com.example.diabetescontrol.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(private val repository: AuthRepository) {

    suspend fun signOut(context: Context){
        repository.signOut(context)
    }
}