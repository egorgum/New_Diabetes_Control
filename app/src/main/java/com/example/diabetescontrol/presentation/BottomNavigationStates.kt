package com.example.diabetescontrol.presentation


import com.example.diabetescontrol.R

sealed class BottomNavigationStates(
    val route: String,
    val iconId: Int
) {
    object Analytics : BottomNavigationStates(
        route = ANALYTICS_ROUTE,
        iconId = R.drawable.baseline_analytics_24
    )

    object Alarm : BottomNavigationStates(
        route = ALARM_ROUTE,
        iconId = R.drawable.baseline_access_alarm_24
    )

    companion object {
        const val ANALYTICS_ROUTE = "analytics"
        const val ALARM_ROUTE = "alarm"
    }
}