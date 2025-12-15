package org.dataprime.emdr.screen.web

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.background_dark
import emdrcompanion.composeapp.generated.resources.background_light
import org.dataprime.emdr.screen.web.forgot.ForgotPassword
import org.dataprime.emdr.screen.web.login.Login
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun WebApp() {

    val mainViewModel: MainViewModel = viewModel {
        MainViewModel()
    }

    val lightsOn by mainViewModel.lightsOn.collectAsState(false)
    val nav = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(
                if (lightsOn) {
                    Res.drawable.background_dark
                } else Res.drawable.background_light
            ),
            contentDescription = null
        )

        NavHost(
            navController = nav,
            startDestination = Login
        ) {
            composable<Login> {
                Login(
                    lightsOn = lightsOn,
                    onForgotClicked = {
                        nav.navigate(route = ForgotPassword)
                    }
                ) { toggled ->
                    mainViewModel.toggleLightsOn(toggled)
                }
            }

            composable<ForgotPassword> {
                ForgotPassword(lightsOn = lightsOn) {
                    nav.navigateUp()
                }
            }
        }
    }
}