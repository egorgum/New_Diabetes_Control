package com.example.diabetescontrol.presentation.screens

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
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.diabetescontrol.R
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme
import com.example.diabetescontrol.presentation.uiComponents.TextInCenterSample
import com.example.diabetescontrol.presentation.uiComponents.WarningDialog
import com.example.diabetescontrol.presentation.viewModels.AccountViewModel

@Composable
fun AccountScreen(viewModel: AccountViewModel, onLogInScreen: () -> Unit) {
    val context = LocalContext.current
    val exitIcon = Icons.Default.Logout
    val isDialogAppeared = remember { mutableStateOf(false) }
    val account = remember { viewModel.account }
    var tabState by remember { mutableIntStateOf(0) }
    val titles = listOf("recipes", "products")
    when(isDialogAppeared.value){
        true -> {
            WarningDialog(
                onDismissRequest = { isDialogAppeared.value = false },
                onConfirmation = {
                    viewModel.signOut(context)
                    onLogInScreen.invoke()
                },
                dialogTitle = stringResource(id = R.string.warning) ,
                dialogText = stringResource(id = R.string.warningText),
                icon = exitIcon
            )}
        false -> {}
    }
    DiabetesControlTheme {

        Column() {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        isDialogAppeared.value = true
                    }
                ) {
                    Image(imageVector = exitIcon, contentDescription = null)
                }
            }

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
            TabRow(selectedTabIndex = tabState) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = tabState == index,
                        onClick = { tabState = index },
                        text = { Text(text = title) }
                    )
                }
            }
        }
    }
}