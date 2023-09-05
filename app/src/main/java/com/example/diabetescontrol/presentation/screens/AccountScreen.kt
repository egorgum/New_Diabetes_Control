package com.example.diabetescontrol.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.diabetescontrol.presentation.viewModels.AccountViewModel

@Composable
fun AccountScreen(viewModel: AccountViewModel, onLogInScreen: () -> Unit) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.End
    ) {
          Button(
              onClick = {
                  viewModel.signOut(context)
                  onLogInScreen.invoke()
              } ) {
              Image(imageVector = Icons.Default.Logout, contentDescription = null)
          }
    }

    LaunchedEffect(key1 = viewModel.hasUser){
        if (!viewModel.hasUser){
            onLogInScreen.invoke()
        }
    }
}