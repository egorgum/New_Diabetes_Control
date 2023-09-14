package com.example.diabetescontrol.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.navigation.bottomNavigation.BottomNavGraph
import com.example.diabetescontrol.presentation.navigation.bottomNavigation.BottomNavigationScreen


@Composable
fun MainScreen(onLogInScreen: () -> Unit){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationScreen(navController = navController) },
        contentWindowInsets = WindowInsets(0.dp,0.dp,0.dp,0.dp)
        ) {
        Column(Modifier.padding(it)){
            BottomNavGraph(navController = navController, onLogInScreen)
        }
    }
}