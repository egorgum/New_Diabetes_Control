package com.example.diabetescontrol.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme
import com.example.diabetescontrol.presentation.theme.PurpleGrey80

@Composable
fun BottomNavigationItem(
    screen: BottomNavigationStates,
    currentDestination: NavDestination?,
    navController: NavController
){
    DiabetesControlTheme {
        val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
        val contentColor =
            if (selected) Color.White else MaterialTheme.colorScheme.onPrimary
        val background =
            if (selected) PurpleGrey80.copy(alpha = 0.6f) else MaterialTheme.colorScheme.primary
        //Settings of item space
        Box(
            modifier = Modifier
                .height(50.dp)
                .clip(CircleShape)
                .background(background)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                )
                {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
        )
        {
            //Settings of icon
            Row(
                modifier = Modifier
                    .padding(
                        start = 10.dp,
                        end = 10.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            )
            {
                Icon(
                    painter = painterResource(id = screen.iconId),
                    contentDescription = "icon",
                    tint = contentColor,
                    modifier = Modifier.height(50.dp).width(50.dp)
                )
                //Touch animation
                AnimatedVisibility(visible = selected) {
                    Text(
                        text = screen.title,
                        color = contentColor
                    )
                }
            }
        }
    }
}