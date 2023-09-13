package com.example.diabetescontrol.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diabetescontrol.R
import com.example.diabetescontrol.presentation.uiComponents.TextInCenterSample

@Composable
fun ErrorScreenForRecipes(
    errorMessage: String,
    update: () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()) {
        TextInCenterSample(text = errorMessage)
        Button(
            onClick = { update() },
        ) {
            Text(
                text = stringResource(id = R.string.update),
            )
        }
    }
}

@Composable
@Preview
fun PreviewErrorScreen(){
    ErrorScreenForRecipes(errorMessage = "Ошибка сети, повторите позже") {
        Log.d("LOL","Update")
    }
}