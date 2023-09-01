package com.example.diabetescontrol.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.diabetescontrol.presentation.screens.MainScreen
import com.example.diabetescontrol.presentation.screens.SignInScreen
import com.example.diabetescontrol.presentation.sign_in.GoogleUIAuthClient
import com.example.diabetescontrol.presentation.theme.DiabetesControlTheme
import com.example.diabetescontrol.presentation.viewModels.SignInViewModel
import com.google.android.gms.auth.api.identity.Identity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private  val googleAuthUiClient by lazy {
        GoogleUIAuthClient(
            context =applicationContext,
            oneTypeClient = Identity.getSignInClient(applicationContext)
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiabetesControlTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "sign_in"){
                    composable("sign_in"){
                        val viewModel = viewModel<SignInViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LaunchedEffect(key1 = Unit){
                            if (googleAuthUiClient.getSignetIdUser() != null){
                                navController.navigate("main_screen")
                            }
                        }

                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.StartIntentSenderForResult(),
                            onResult = { result ->
                                if (result.resultCode == RESULT_OK){
                                    lifecycleScope.launch {
                                        val signInResult = googleAuthUiClient.signInWithIntent(
                                            intent = result.data ?: return@launch
                                        )
                                        viewModel.onSignInResult(signInResult)
                                    }
                                }
                            }
                        )
                        SignInScreen(
                            state = state,
                            onSignInClick = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            }
                        )

                        LaunchedEffect(key1 = state.isSignInSuccessful){
                            if (state.isSignInSuccessful){
                                Toast.makeText(
                                    applicationContext,
                                    "Sign in successful",
                                    Toast.LENGTH_LONG
                                ).show()
                                navController.navigate("main_screen")
                                viewModel.resetState()
                            }
                        }
                    }
                    composable("main_screen"){
                        MainScreen()
                    }
                }
            }
        }

    }
}

