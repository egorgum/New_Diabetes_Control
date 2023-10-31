package com.example.diabetescontrol.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.diabetescontrol.R
import com.example.diabetescontrol.presentation.uiComponents.LoadingSample
import com.example.diabetescontrol.presentation.uiComponents.Separator
import com.example.diabetescontrol.presentation.uiComponents.TextInCenterSample
import com.example.diabetescontrol.presentation.uiComponents.accountScreenList.ListOfDatesAndMeasurements
import com.example.diabetescontrol.presentation.uiComponents.dialogs.ExitDialog
import com.example.diabetescontrol.presentation.uiComponents.dialogs.MeasurementDialog
import com.example.diabetescontrol.presentation.viewModels.AccountViewModel

@Composable
fun AccountScreen(viewModel: AccountViewModel, onLogInScreen: () -> Unit) {

    val context = LocalContext.current
    val exitIcon = Icons.Default.Logout
    val account = remember { viewModel.account }
    val state by remember { viewModel.stateOfLoading }

    //Dialogs
    val isExitDialogAppeared = remember { mutableStateOf(false) }
    val isMeasurementDialogAppeared = remember { mutableStateOf(false) }

    if (isMeasurementDialogAppeared.value) {
        MeasurementDialog(
            onDismissRequest = { isMeasurementDialogAppeared.value = false },
            onConfirmation = {
                viewModel.setMeasurement(it)
                isMeasurementDialogAppeared.value = false
            },
            errorAction = {
                Toast.makeText(
                    context,
                    context.getText(R.string.error),
                    Toast.LENGTH_SHORT
                ) .show()
                isMeasurementDialogAppeared.value = false
            }
        )
    }
    if (isExitDialogAppeared.value) {
        ExitDialog(onDismissRequest = { isExitDialogAppeared.value = false }) {
            viewModel.signOut(context)
            onLogInScreen.invoke()
        }
    }
    ////

    Scaffold(
        //Add measurement
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isMeasurementDialogAppeared.value = true
                }
            ) { Icon(Icons.Filled.Add, "") }
        }
    ) {


        Column(Modifier.padding(it)) {
            //Exit
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        isExitDialogAppeared.value = true
                    }
                ) {
                    Image(imageVector = exitIcon, contentDescription = null)
                }
            }
            //User Information
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = account.value?.img,
                    contentDescription = "avatar",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = CircleShape
                        ),
                )
            }
            TextInCenterSample(text = account.value!!.userEmail)

            Separator()

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.glucose_measurement_log),
                    fontSize = 25.sp
                )
            }

            //Logs
            when (state) {
                is LoadStates.Loading -> LoadingSample()
                is LoadStates.Error -> {
                    ErrorScreenForRecipes(
                        errorMessage = (state as LoadStates.Error).errorMessage
                    ) { viewModel.getMeasurements() }
                }

                is LoadStates.Success -> {
                    ListOfDatesAndMeasurements(list = viewModel.measurements)
                }

                is LoadStates.Default -> {}
            }
        }
    }
}
