package com.example.diabetescontrol.presentation.navigation

//Types of navigation
sealed class AppNavigationStates(val route: String) {

    data object Reg :AppNavigationStates(
        route = REG_ROUTE,
    )

    data object Bottom :AppNavigationStates(
        route = BOTTOM_ROUTE,
    )

    companion object {
        private const val REG_ROUTE = "reg_route"
        private const val BOTTOM_ROUTE = "bottom_route"
    }

}
