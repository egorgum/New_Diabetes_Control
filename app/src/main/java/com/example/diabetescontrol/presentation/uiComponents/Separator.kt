package com.example.diabetescontrol.presentation.uiComponents

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Separator() {
    Text(
        text = "",
        Modifier
            .border(1.dp, Color.Gray)
            .fillMaxWidth()
            .height(1.dp)
    )
}