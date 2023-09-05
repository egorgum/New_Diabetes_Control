package com.example.diabetescontrol.data.repocitory

import android.content.Context
import com.example.diabetescontrol.R
import com.example.diabetescontrol.domain.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val currentUser:FirebaseUser?,

    ): AuthRepository {


    override fun hasUser(): Boolean {
        return Firebase.auth.currentUser != null
    }

    override fun getUserId(): String = Firebase.auth.currentUser?.uid.orEmpty()

    override suspend fun createUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ): Unit = withContext(Dispatchers.IO){
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onComplete.invoke(true)
                }
                else{
                    onComplete.invoke(false)
                }
            }.await()
    }

    override suspend fun loginUser(
        email: String,
        password: String,
        onComplete: (Boolean) -> Unit
    ): Unit = withContext(Dispatchers.IO){
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onComplete.invoke(true)
                }
                else{
                    onComplete.invoke(false)
                }
            }.await()
    }

    override suspend fun googleLogin(
        credential: AuthCredential,
        onComplete: (Boolean) -> Unit
    ): Unit = withContext(Dispatchers.IO){
            Firebase.auth
                .signInWithCredential(credential)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        onComplete.invoke(true)
                    }
                    else{
                        onComplete.invoke(false)
                    }
                }.await()
        }


    override fun signOut(context: Context) {
        getClient(context).signOut()// Log out of Google account
        Firebase.auth.signOut()
    }

    override fun getClient(context: Context): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .build()

        return GoogleSignIn.getClient(context, gso)
    }


}