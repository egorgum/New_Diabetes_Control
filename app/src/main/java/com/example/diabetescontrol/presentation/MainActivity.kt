package com.example.diabetescontrol.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.navigation.AppNavigation
//import com.example.diabetescontrol.presentation.sign_in.GoogleUIAuthClient
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme
import com.example.diabetescontrol.presentation.viewModels.AccountViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiabetesControlTheme {
                val viewModel = hiltViewModel<AccountViewModel>()
                AppNavigation(navController = rememberNavController(), hasUser = viewModel.hasUser)
            }
        }

    }
}

