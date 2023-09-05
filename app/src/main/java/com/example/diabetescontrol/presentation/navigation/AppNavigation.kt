package com.example.diabetescontrol.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.screens.LogInScreen
import com.example.diabetescontrol.presentation.screens.MainScreen
import com.example.diabetescontrol.presentation.screens.SignUpScreen
import com.example.diabetescontrol.presentation.viewModels.LoginViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
) {

    //Main Navigation
    NavHost(
        navController = navController,
        startDestination = ScreensNavigationStates.LogIn.route,
        route = AppNavigationStates.Reg.route){

        composable(ScreensNavigationStates.SignUp.route){

            SignUpScreen(
                viewModel = hiltViewModel<LoginViewModel>(),
                onNavToMainScreen = {
                    navController.navigate(ScreensNavigationStates.Main.route) {
                        launchSingleTop = true
                        popUpTo(ScreensNavigationStates.SignUp.route){
                            inclusive = true
                        }
                    }
                },
                onNavToLoginScreen = {
                    navController.navigate(ScreensNavigationStates.LogIn.route){
                        launchSingleTop = true
                        popUpTo(ScreensNavigationStates.SignUp.route){
                            inclusive = true
                        }
                    }
                },
            )
        }

        composable(ScreensNavigationStates.LogIn.route){
            LogInScreen(
                viewModel = hiltViewModel<LoginViewModel>(),
                onNavToSignUpScreen = {
                    navController.navigate(ScreensNavigationStates.SignUp.route){
                        launchSingleTop = true
                        popUpTo(ScreensNavigationStates.SignUp.route){
                            inclusive = true
                        }
                    }
                },
                onNavToMainScreen = {
                    navController.navigate(ScreensNavigationStates.Main.route){

                    }
                }
            )
        }

        composable(ScreensNavigationStates.Main.route){
            MainScreen(
                onLogInScreen = {
                    navController.navigate(ScreensNavigationStates.LogIn.route){
                        popUpTo(ScreensNavigationStates.Main.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}