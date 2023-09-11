package com.example.diabetescontrol.presentation.viewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diabetescontrol.R
import com.example.diabetescontrol.domain.entities.LoginState
import com.example.diabetescontrol.domain.useCase.loginUseCases.CreateUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.GetClientUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.GoogleLoginUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.HasUserUseCase
import com.example.diabetescontrol.domain.useCase.loginUseCases.LoginUserUseCase
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val hasUserUseCase: HasUserUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase,
    private val googleLoginUseCase: GoogleLoginUseCase,
    private val getClientUseCase: GetClientUseCase
) : ViewModel() {

    val hasUser: Boolean
        get() = hasUserUseCase.hasUser()

    var loginState by mutableStateOf(LoginState())
        private set


    fun onUserNameSignUpChanged(userName: String) {
        loginState = loginState.copy(userNameSignUp = userName)
    }

    fun onPasswordSignUpChanged(password: String) {
        loginState = loginState.copy(passwordSignUp = password)
    }

    fun onConfirmPasswordSignUpChanged(password: String) {
        loginState = loginState.copy(confirmPasswordSignUp = password)
    }

    fun onUserNameChanged(useName: String) {
        loginState = loginState.copy(userName = useName)
    }

    fun onPasswordChanged(password: String) {
        loginState = loginState.copy(password = password)
    }

    private fun validateLoginForm() =
        loginState.userName.isNotBlank() && loginState.password.isNotBlank()

    private fun validateSignUpForm() =
        loginState.userNameSignUp.isNotBlank() &&
                loginState.passwordSignUp.isNotBlank() &&
                loginState.confirmPasswordSignUp.isNotBlank()


    fun createUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignUpForm()) {
                throw IllegalArgumentException(
                    context.getString(R.string.email_and_password_can_not_be_empty)
                )
            }
            loginState = loginState.copy(isLoading = true)
            if (loginState.passwordSignUp != loginState.confirmPasswordSignUp) {
                throw IllegalArgumentException(
                    context.getString(R.string.password_do_not_match)
                )
            }
            loginState = loginState.copy(signUpError = null)
            createUserUseCase.createUser(
                email = loginState.userNameSignUp,
                password = loginState.passwordSignUp
            ) { isSuccess ->
                loginState =
                    if (isSuccess) {
                        Toast.makeText(
                            context,
                            context.getString(R.string.success_login),
                            Toast.LENGTH_LONG
                        ).show()
                        loginState.copy(isSuccessLogin = true)
                    }
                    else {
                        Toast.makeText(
                            context,
                            context.getString(R.string.failed_login),
                            Toast.LENGTH_LONG
                        ).show()
                        loginState.copy(isSuccessLogin = false)
                    }
            }
        } catch (e: Exception) {
            loginState = loginState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            loginState = loginState.copy(isLoading = false)
        }
    }

    fun loginUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateLoginForm()) {
                throw IllegalArgumentException(
                    context.getString(R.string.email_and_password_can_not_be_empty)
                )
            }
            loginState = loginState.copy(isLoading = true)
            loginState = loginState.copy(loginError = null)
            loginUserUseCase.loginUser(
                email = loginState.userName,
                password = loginState.password
            ) { isSuccess ->
                loginState = if (isSuccess) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.success_login),
                        Toast.LENGTH_LONG
                    ).show()
                    loginState.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.failed_login),
                        Toast.LENGTH_LONG
                    ).show()
                    loginState.copy(isSuccessLogin = false)
                }
            }
        } catch (e: Exception) {
            loginState = loginState.copy(loginError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            loginState = loginState.copy(isLoading = false)
        }
    }

    fun googleLogin(
        context: Context,
        credential: AuthCredential
    ) = viewModelScope.launch {
        try {
            loginState = loginState.copy(isLoading = true)
            loginState = loginState.copy(loginError = null)
            googleLoginUseCase.googleLogin(
                credential = credential
            ) { isSuccess ->
                loginState = if (isSuccess) {
                    Toast.makeText(
                        context,
                        context.getString(R.string.success_login),
                        Toast.LENGTH_LONG
                    ).show()
                    loginState.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.failed_login),
                        Toast.LENGTH_LONG
                    ).show()
                    loginState.copy(isSuccessLogin = false)
                }
            }
        } catch (e: Exception) {
            loginState = loginState.copy(loginError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            loginState = loginState.copy(isLoading = false)
        }
    }

    fun getClient(context: Context): GoogleSignInClient {
        return getClientUseCase.getClient(context)
    }

}