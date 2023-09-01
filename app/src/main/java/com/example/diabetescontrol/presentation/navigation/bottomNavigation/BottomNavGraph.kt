package com.example.diabetescontrol.presentation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diabetescontrol.presentation.screens.AccountScreen
import com.example.diabetescontrol.presentation.screens.AnalyticsScreen
import com.example.diabetescontrol.presentation.screens.recipesScreen.RecipesScreen
import com.example.diabetescontrol.presentation.screens.searchScreen.SearchScreen
import com.example.diabetescontrol.presentation.sign_in.UserData

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
            SearchScreen(hiltViewModel())
        }

        composable(route = BottomNavigationStates.ACCOUNT_ROUTE){
           // AccountScreen(user = UserData(userId = ))
        }
    }
}