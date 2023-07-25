package com.example.diabetescontrol.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationStates.ANALYTICS_ROUTE
    )
    {

        composable(route = BottomNavigationStates.ANALYTICS_ROUTE) {
            AnalyticsScreen()
        }

        composable(route = BottomNavigationStates.RECIPES_ROUTE) {
            RecipesScreen()
        }

        composable(route = BottomNavigationStates.SEARCHING_ROUTE) {
            SearchingScreen()
        }
    }
}