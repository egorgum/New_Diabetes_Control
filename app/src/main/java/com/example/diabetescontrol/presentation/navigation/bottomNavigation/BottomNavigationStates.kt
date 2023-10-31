package com.example.diabetescontrol.presentation.navigation.bottomNavigation


import com.example.diabetescontrol.R

sealed class BottomNavigationStates(
    val route: String,
    val iconId: Int,
    val titleRes: Int,
) {
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
    data object Account: BottomNavigationStates(
        route = ACCOUNT_ROUTE,
        iconId = R.drawable.baseline_person_24,
        titleRes = R.string.account
    )

    companion object {
        const val RECIPES_ROUTE = "recipes_route"
        const val SEARCHING_ROUTE = "searching_route"
        const val ACCOUNT_ROUTE = "account_route"
    }
}