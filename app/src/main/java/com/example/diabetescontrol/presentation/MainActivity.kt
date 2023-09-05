package com.example.diabetescontrol.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.navigation.AppNavigation
//import com.example.diabetescontrol.presentation.sign_in.GoogleUIAuthClient
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiabetesControlTheme {
                AppNavigation(navController = rememberNavController())
            }
        }

    }
}

