package com.example.diabetescontrol.presentation.uiComponents.bottomNavigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme

//Bottom bar
@Composable
fun BottomNavigationScreen(navController: NavController) {
    //Screens list
    val listItems = listOf(
        BottomNavigationStates.Recipes,
        BottomNavigationStates.Analytics,
        BottomNavigationStates.Search
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination
    //Settings of bottom bar design
    DiabetesControlTheme {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listItems.forEach { screen ->
                BottomNavigationItem(
                    screen = screen,
                    currentDestination = currentRoute,
                    navController = navController
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewBottomNav() {
    val navController = rememberNavController()
    BottomNavigationScreen(navController = navController)
}
