package com.example.diabetescontrol.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.BottomNavGraph
import com.example.diabetescontrol.presentation.BottomNavigationScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigationScreen(navController = navController)}) {
        BottomNavGraph(navController = navController)
    }
}