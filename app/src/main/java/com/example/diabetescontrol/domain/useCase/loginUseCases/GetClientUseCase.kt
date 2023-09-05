package com.example.diabetescontrol.domain.useCase.loginUseCases

import android.content.Context
import com.example.diabetescontrol.domain.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import javax.inject.Inject

class GetClientUseCase @Inject constructor(private val repository: AuthRepository) {
    fun getClient(context: Context): GoogleSignInClient {
        return repository.getClient(context)
    }
}