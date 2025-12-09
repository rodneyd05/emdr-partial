package org.dataprime.emdr.screen.web

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.background_dark
import emdrcompanion.composeapp.generated.resources.background_light
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Login(lightsOn = lightsOn) { toggled ->
                mainViewModel.toggleLightsOn(toggled)
            }
        }
    }
}