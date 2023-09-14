package com.example.diabetescontrol.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.diabetescontrol.presentation.viewModels.LoginViewModel


@Composable
fun SignUpScreen(
    viewModel: LoginViewModel,
    onNavToMainScreen: () -> Unit,
    onNavToLoginScreen: () -> Unit,
) {

    val loginState = viewModel.loginState
    val isError = loginState.signUpError != null
    val context = LocalContext.current
    val textColorForTextField = OutlinedTextFieldDefaults.colors(
        focusedTextColor = Color.Black,
        disabledTextColor = Color.Black,
        errorTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)) {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.sign_up),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 50.sp
            )

            if (isError) {
                androidx.compose.material3.Text(
                    text = loginState.signUpError ?: stringResource(id = R.string.unknown_error),
                    color = Color.Red
                )
            }

            OutlinedTextField(
                value = loginState.userNameSignUp,
                onValueChange = { viewModel.onUserNameSignUpChanged(it) },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                label = {
                    androidx.compose.material3.Text(
                        text = stringResource(id = R.string.email),
                        color = Color.Black
                    )
                },
                isError = isError,
                modifier = Modifier.fillMaxWidth(),
                colors = textColorForTextField
            )

            OutlinedTextField(
                value = loginState.passwordSignUp,
                onValueChange = { viewModel.onPasswordSignUpChanged(it) },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                label = {
                    androidx.compose.material3.Text(
                        text = stringResource(id = R.string.password),
                        color = Color.Black
                    )
                },
                isError = isError,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = textColorForTextField
            )

            OutlinedTextField(
                value = loginState.confirmPasswordSignUp,
                onValueChange = { viewModel.onConfirmPasswordSignUpChanged(it) },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
                label = {
                    androidx.compose.material3.Text(
                        text = stringResource(id = R.string.confirm_password),
                        color = Color.Black
                    )
                },
                isError = isError,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = textColorForTextField
            )

            androidx.compose.material3.Button(
                onClick = { viewModel.createUser(context) },
                modifier = Modifier.fillMaxWidth()) {
                androidx.compose.material3.Text(text = stringResource(id = R.string.sign_up))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {

                androidx.compose.material3.Text(
                    text = stringResource(id = R.string.already_have_an_account),
                )

                TextButton(onClick = { onNavToLoginScreen.invoke() }) {
                    androidx.compose.material3.Text(text = stringResource(id = R.string.log_in))
                }
            }

            if (loginState.isLoading) CircularProgressIndicator()


            LaunchedEffect(key1 = viewModel.hasUser) {
                if (viewModel.hasUser) onNavToMainScreen.invoke()

            }
        }

    }

}