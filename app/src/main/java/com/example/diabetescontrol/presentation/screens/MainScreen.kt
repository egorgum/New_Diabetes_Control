package com.example.diabetescontrol.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.uiComponents.bottomNavigation.BottomNavGraph
import com.example.diabetescontrol.presentation.uiComponents.bottomNavigation.BottomNavigationScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigationScreen(navController = navController) }) {
        Column(Modifier.padding(it)){
            BottomNavGraph(navController = navController)
        }
    }
}