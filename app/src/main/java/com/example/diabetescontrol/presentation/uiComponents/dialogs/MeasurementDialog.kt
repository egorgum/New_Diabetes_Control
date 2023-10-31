package com.example.diabetescontrol.presentation.uiComponents.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.diabetescontrol.R

@Composable
fun MeasurementDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Double) -> Unit,
    errorAction: () -> Unit
) {
    val openDialog = remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }
    if (openDialog.value) {
        AlertDialog(
            icon = {
                Icon(Icons.Default.WaterDrop, contentDescription = "Exit")
            },
            title = {
                Text(text = stringResource(id = R.string.measurement_dialog_title))
            },
            text = {
                Column {
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            },
            onDismissRequest = {
                onDismissRequest.invoke()
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        try {
                            onConfirmation(text.toDouble())
                        }
                        catch (e: Exception){
                            errorAction.invoke()
                        }

                    }
                ) {
                    Text(stringResource(id = R.string.confirm))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismissRequest.invoke() }
                ) {
                    Text(stringResource(id = R.string.dismiss))
                }
            }
        )
    }
}
