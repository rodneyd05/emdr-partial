package org.dataprime.emdr.screen.web.forgot

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
fun ForgotPasswordSuccessAlert(
    modifier: Modifier = Modifier,
    lightsOn: Boolean,
    onGoBackClicked: () -> Unit
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
            text = "Check your email",
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
            text = "If you don’t see it, check your spam or junk folder, or make \n sure you’re using the correct email for your account. \n You can also resend the link below.",
            fontSize = 16.sp,
            fontFamily = InterSemiBold,
            textAlign = TextAlign.Center,
            color = if (lightsOn) {
                Color.White
            } else Text300,
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
            onClick = {

            },
        ) {
            Text(
                text = "Resend email",
                fontSize = 16.sp,
                fontFamily = NunitoSemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .clickable(onClick = onGoBackClicked),
            text = "Go back to sign in page",
            fontSize = 14.sp,
            fontFamily = NunitoSemiBold,
            color = if (lightsOn) Primary500 else Primary700,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun ForgotPasswordSuccessAlertPreview() {
    ForgotPasswordSuccessAlert(
        modifier = Modifier.padding(16.dp),
        onGoBackClicked = {

        },
        lightsOn = false
    )
}