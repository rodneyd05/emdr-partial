package org.dataprime.emdr.screen.web.forgot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dataprime.emdr.theme.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ForgotPassword(
    modifier: Modifier = Modifier,
    lightsOn: Boolean
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Forgot Your Password?",
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
            text = "Please enter your email address, and \n we'll send you a secure link to reset your password",
            fontSize = 16.sp,
            fontFamily = InterSemiBold,
            textAlign = TextAlign.Center,
            color = if (lightsOn) {
                Color.White
            } else Text300,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(36.dp))

        Column(
            modifier = Modifier
                .shadow(
                    elevation = 2.dp,
                    shape = RoundedCornerShape(8.dp),
                    //spotColor = Color(0xFF0C0C0D0D),
                    ambientColor = Color(0xFF0C0C0D0D)
                )
                .clip(RoundedCornerShape(8.dp))
                .background(Gray500)
                .widthIn(max = 464.dp)
                //only vertical is set since checkbox has its own padding
                .padding(vertical = 28.dp),
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "Email Address",
                fontSize = 16.sp,
                fontFamily = NunitoBold,
                color = Text500
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                colors = OutlinedTextFieldColor,
                value = email,
                onValueChange = {
                    email = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonColor,
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                onClick = {

                },
            ) {
                Text(
                    text = "Submit",
                    fontSize = 16.sp,
                    fontFamily = NunitoSemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "Go back to sign in page",
                fontSize = 14.sp,
                fontFamily = NunitoSemiBold,
                color = Primary700,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun LoginPreview() {
    ForgotPassword(
        modifier = Modifier.padding(16.dp),
        lightsOn = false
    )
}