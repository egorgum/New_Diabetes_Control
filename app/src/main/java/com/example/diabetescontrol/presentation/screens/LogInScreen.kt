package com.example.diabetescontrol.presentation.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diabetescontrol.R
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme
import com.example.diabetescontrol.presentation.viewModels.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun LogInScreen(
    viewModel: LoginViewModel,
    onNavToMainScreen: () -> Unit,
    onNavToSignUpScreen: () -> Unit,
) {

    val loginState = viewModel.loginState
    val isError = loginState.loginError != null
    val context = LocalContext.current
    val textColorForTextField = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        disabledTextColor = Color.Black,
        errorTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
    )

    //Launcher for launching the account selection menu
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {

        val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)//Selected account

        try {
            val result = account.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(result.idToken, null)
            viewModel.googleLogin(context, credential)//Auth
        } catch (e: ApiException) {
            Log.d("LOL", "${context.getString(R.string.error)}: ${e.localizedMessage}")
        }
    }
    DiabetesControlTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.log_in),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 50.sp
                )

                if (isError) {
                    Text(
                        text = loginState.loginError ?: stringResource(id = R.string.unknown_error),
                        color = Color.Red
                    )
                }

                OutlinedTextField(
                    value = loginState.userName,
                    onValueChange = { viewModel.onUserNameChanged(it) },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null)
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.email),
                            color = Color.Black
                        )
                    },
                    isError = isError,
                    modifier = Modifier.fillMaxWidth(),
                    colors = textColorForTextField
                )

                OutlinedTextField(
                    value = loginState.password,
                    onValueChange = { viewModel.onPasswordChanged(it) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(id = R.string.password),
                            color = Color.Black
                        )
                    },
                    isError = isError,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = textColorForTextField
                )

                Button(
                    onClick = { viewModel.loginUser(context) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.log_in))
                }

                Button(
                    onClick = {
                        launcher.launch(viewModel.getClient(context).signInIntent)//Get Google client //
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.google))
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(id = R.string.do_not_have_an_account))
                    TextButton(onClick = { onNavToSignUpScreen.invoke() }) {
                        Text(text = stringResource(id = R.string.sign_up))
                    }
                }

                if (loginState.isLoading) CircularProgressIndicator()

                LaunchedEffect(key1 = viewModel.hasUser) {
                    if (viewModel.hasUser) onNavToMainScreen.invoke()

                }
            }
        }
    }
}