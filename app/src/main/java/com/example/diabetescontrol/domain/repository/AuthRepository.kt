package com.example.diabetescontrol.domain.repository

import android.content.Intent
import com.example.diabetescontrol.presentation.sign_in.SignInResult
import com.example.diabetescontrol.presentation.navigation.AppNavigationStates
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import java.util.concurrent.Flow

interface AuthRepository {

    suspend fun googleSignIn(intent: Intent): SignInResult

}