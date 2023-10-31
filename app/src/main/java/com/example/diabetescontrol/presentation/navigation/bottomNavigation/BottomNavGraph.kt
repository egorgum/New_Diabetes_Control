package com.example.diabetescontrol.presentation.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diabetescontrol.presentation.navigation.AppNavigationStates
import com.example.diabetescontrol.presentation.screens.AccountScreen
import com.example.diabetescontrol.presentation.screens.recipesScreen.RecipesScreen
import com.example.diabetescontrol.presentation.screens.searchScreen.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController, onLogInScreen: () -> Unit) {

    NavHost(
        navController = navController,
        startDestination = BottomNavigationStates.ACCOUNT_ROUTE,
        route = AppNavigationStates.Bottom.route
    )
    {
        composable(route = BottomNavigationStates.RECIPES_ROUTE) {
            RecipesScreen(hiltViewModel())
        }

        composable(route = BottomNavigationStates.SEARCHING_ROUTE) {
            SearchScreen(hiltViewModel())
        }

        composable(route = BottomNavigationStates.ACCOUNT_ROUTE){
            AccountScreen(
                viewModel = hiltViewModel(),
                onLogInScreen = onLogInScreen,
            )
        }
    }
}