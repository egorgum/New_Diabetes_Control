package com.example.diabetescontrol.presentation.navigation

sealed class AppNavigationStates(val route: String) {

    data object SignIn :AppNavigationStates(
        route = SIGN_IN_ROUTE,
    )

    data object Main :AppNavigationStates(
        route = MAIN_ROUTE,
    )

    companion object {
        const val SIGN_IN_ROUTE = "sign_in_route"
        const val MAIN_ROUTE = "recipes_route"
    }
}