package com.example.diabetescontrol.presentation.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.example.diabetescontrol.R
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
    val clientId = stringResource(id = R.string.default_web_client_id)

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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.log_in),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )

        if (isError) {
            Text(
                text = loginState.loginError ?: stringResource(id = R.string.unknown_error),
                color = Color.Red
            )
        }

        OutlinedTextField(
            value = loginState.userName,
            onValueChange = {
                viewModel.onUserNameChanged(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(text = stringResource(id = R.string.email), color = Color.Black)
            },
            isError = isError
        )

        OutlinedTextField(
            value = loginState.password,
            onValueChange = {
                viewModel.onPasswordChanged(it)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            label = {
                Text(
                    text = stringResource(id = R.string.password), color = Color.Black
                )
            },
            isError = isError,
            visualTransformation = PasswordVisualTransformation()
        )

        Button(onClick = {

            launcher.launch(viewModel.getClient(context).signInIntent)//Get Google client

        }) {
            Text(text = stringResource(id = R.string.google))
        }

        Button(onClick = { viewModel.loginUser(context) }) {
            Text(text = stringResource(id = R.string.log_in))
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {

            Text(text = stringResource(id = R.string.do_not_have_an_account))

            Spacer(modifier = Modifier.size(8.dp))

            TextButton(onClick = { onNavToSignUpScreen.invoke() }) {
                Text(text = stringResource(id = R.string.sign_up))
            }
        }

        if (loginState.isLoading) {
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = viewModel.hasUser) {
            if (viewModel.hasUser) {
                onNavToMainScreen.invoke()
            }
        }

    }

}