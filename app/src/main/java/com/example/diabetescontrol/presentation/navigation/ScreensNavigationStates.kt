package com.example.diabetescontrol.presentation.navigation

sealed class ScreensNavigationStates(val route: String) {

    data object LogIn :ScreensNavigationStates(
        route = LOG_IN_ROUTE,
    )

    data object Main :ScreensNavigationStates(
        route = MAIN_ROUTE,
    )

    data object SignUp :ScreensNavigationStates(
        route = SIGN_UP_ROUTE,
    )

    companion object {
        private const val LOG_IN_ROUTE = "log_in_route"
        private const val MAIN_ROUTE = "main_route"
        private const val SIGN_UP_ROUTE = "sign_up_route"
    }
}