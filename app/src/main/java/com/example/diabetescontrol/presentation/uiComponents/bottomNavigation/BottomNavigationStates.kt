package com.example.diabetescontrol.presentation.uiComponents.bottomNavigation


import com.example.diabetescontrol.R

sealed class BottomNavigationStates(
    val route: String,
    val iconId: Int,
    val titleRes: Int,
) {
    data object Analytics : BottomNavigationStates(
        route = ANALYTICS_ROUTE,
        iconId = R.drawable.baseline_analytics_24,
        titleRes = R.string.analytics
    )

    data object Recipes : BottomNavigationStates(
        route = RECIPES_ROUTE,
        iconId = R.drawable.baseline_menu_book_24,
        titleRes = R.string.recipes
    )

    data object Search: BottomNavigationStates(
        route = SEARCHING_ROUTE,
        iconId = R.drawable.baseline_search_24,
        titleRes = R.string.search
    )

    companion object {
        const val ANALYTICS_ROUTE = "analytics_route"
        const val RECIPES_ROUTE = "recipes_route"
        const val SEARCHING_ROUTE = "searching_route"
    }
}