package com.example.diabetescontrol.presentation


import com.example.diabetescontrol.R

sealed class BottomNavigationStates(
    val route: String,
    val iconId: Int,
    val title: String,
    //val iconFocused: Int
) {
    object Analytics : BottomNavigationStates(
        route = ANALYTICS_ROUTE,
        iconId = R.drawable.baseline_analytics_24,
        title = ANALYTICS_TITLE
    )

    object Recipes : BottomNavigationStates(
        route = RECIPES_ROUTE,
        iconId = R.drawable.baseline_menu_book_24,
        title = RECIPES_TITLE
    )

    object Searching: BottomNavigationStates(
        route = SEARCHING_ROUTE,
        iconId = R.drawable.baseline_search_24,
        title = SEARCHING_TITLE
    )

    companion object {

        const val ANALYTICS_ROUTE = "analytics_route"
        const val RECIPES_ROUTE = "recipes_route"
        const val SEARCHING_ROUTE = "searching_route"

        const val ANALYTICS_TITLE = "Analytics"
        const val RECIPES_TITLE = "Recipes"
        const val SEARCHING_TITLE = "Searching"

    }
}