package com.example.diabetescontrol.presentation.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.diabetescontrol.domain.useCase.loginUseCases.HasUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val signOutUseCase: SignOutUseCase,
    private val hasUserUseCase: HasUserUseCase,
): ViewModel() {

    val hasUser: Boolean
        get() = hasUserUseCase.hasUser()


    fun signOut(context: Context){
        signOutUseCase.signOut(context)
    }
}