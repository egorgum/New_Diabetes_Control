package com.example.diabetescontrol.presentation.viewModels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.domain.useCase.DeleteAllHistoryUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.GetUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.HasUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val signOutUseCase: SignOutUseCase,
    private val hasUserUseCase: HasUserUseCase,
    private val deleteAllHistoryUseCase: DeleteAllHistoryUseCase,
    getUserUseCase: GetUserUseCase
): ViewModel() {
    val account = mutableStateOf(getUserUseCase.getUser())
    val hasUser: Boolean
        get() = hasUserUseCase.hasUser()
    fun signOut(context: Context){
        viewModelScope.launch {
            deleteAllHistoryUseCase.deleteAllHistory()
            signOutUseCase.signOut(context)
        }
    }
}