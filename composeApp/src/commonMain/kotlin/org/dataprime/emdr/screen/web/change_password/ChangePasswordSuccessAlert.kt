package org.dataprime.emdr.screen.web.change_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.check
import org.dataprime.emdr.theme.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChangePasswordSuccessAlert(
    modifier: Modifier = Modifier,
    lightsOn: Boolean,
    onLoginClicked: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(Res.drawable.check),
            contentDescription = null
        )

        Text(
            text = "Password updated successfully",
            fontSize = 24.sp,
            fontFamily = InterSemiBold,
            color = if (lightsOn) {
                Color.White
            } else Text500,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Your password has been changed. \n You'll be redirected to the login page shortly.",
            fontSize = 16.sp,
            fontFamily = InterSemiBold,
            textAlign = TextAlign.Center,
            color = if (lightsOn) {
                Color.White
            } else Text300,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "redirecting in 5s...",
            fontSize = 14.sp,
            fontFamily = InterSemiBold,
            textAlign = TextAlign.Center,
            color = if (lightsOn) {
                Primary200
            } else Primary500,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(36.dp))

        Button(
            modifier = Modifier
                .width(512.dp)
                .padding(horizontal = 24.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonColor,
            enabled = email.isNotEmpty() && password.isNotEmpty(),
            onClick = onLoginClicked,
        ) {
            Text(
                text = "Log in account",
                fontSize = 16.sp,
                fontFamily = NunitoSemiBold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun ChangePasswordSuccessAlertPreview() {
    ChangePasswordSuccessAlert(
        modifier = Modifier.padding(16.dp),
        onLoginClicked = {

        },
        lightsOn = false
    )
}