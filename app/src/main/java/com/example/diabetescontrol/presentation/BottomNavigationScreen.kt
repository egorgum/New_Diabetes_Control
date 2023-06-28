package com.example.diabetescontrol.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationScreen(navController: NavController) {

    val listItems = listOf(BottomNavigationStates.Alarm, BottomNavigationStates.Analytics)

    BottomNavigation() {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = ""
                    )
                },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray
            )
        }
    }
}