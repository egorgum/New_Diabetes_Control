package com.example.diabetescontrol.presentation.uiComponents.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diabetescontrol.presentation.SearchingScreenViewModel
import com.example.diabetescontrol.presentation.screens.AnalyticsScreen
import com.example.diabetescontrol.presentation.screens.RecipesScreen
import com.example.diabetescontrol.presentation.screens.SearchingScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    //For saving State of viewModel
    val viewModelStoreOwner = LocalViewModelStoreOwner.current

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
            val viewModel: SearchingScreenViewModel = hiltViewModel(viewModelStoreOwner!!)
            SearchingScreen(viewModel)
        }
    }
}