package com.example.diabetescontrol.data.mapper

import com.example.diabetescontrol.domain.entities.AccountInfo
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthMapper @Inject constructor(){
    fun mapFireBaseUserToAccountInfo(fUser: FirebaseUser): AccountInfo {
        return AccountInfo(
            img = fUser.photoUrl?.toString(),
            userEmail = fUser.email!!
        )
    }
}