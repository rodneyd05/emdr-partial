package org.dataprime.emdr.screen.web.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.eye_black
import emdrcompanion.composeapp.generated.resources.eye_white
import emdrcompanion.composeapp.generated.resources.sun
import org.dataprime.emdr.theme.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Login(
    modifier: Modifier = Modifier,
    lightsOn: Boolean,
    onForgotClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    onLightsOnToggled: (Boolean) -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isRememberMeChecked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(120.dp),
            painter = painterResource(resource = if (lightsOn) {
                Res.drawable.eye_white
            } else Res.drawable.eye_black
            ),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "Welcome to EMDR Companion",
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
            text = "Sign in using your work email to get started",
            fontSize = 16.sp,
            fontFamily = InterSemiBold,
            color = if (lightsOn) {
                Color.White
            } else Text300,
            maxLines = 1,
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

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "Password",
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
                visualTransformation = PasswordVisualTransformation(),
                value = password,
                onValueChange = {
                    password = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Checkbox(
                    modifier = Modifier.padding(start = 10.dp),
                    colors = CheckBoxColor,
                    checked = isRememberMeChecked,
                    onCheckedChange = {
                        isRememberMeChecked = !isRememberMeChecked
                    }
                )

                Text(
                    text = "Remember me",
                    fontSize = 14.sp,
                    fontFamily = NunitoMedium,
                    color = Text500
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    modifier = Modifier
                        .padding(end = 24.dp)
                        .clickable(
                            onClick = onForgotClicked
                        ),
                    text = "Forgot Password?",
                    fontSize = 14.sp,
                    fontFamily = NunitoSemiBold,
                    color = Primary500
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonColor,
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                onClick = onSignInClicked,
            ) {
                Text(
                    text = "Sign In",
                    fontSize = 16.sp,
                    fontFamily = NunitoSemiBold,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(
                colors = SwitchColor,
                thumbContent = {
                    Image(
                        painter = painterResource(Res.drawable.sun),
                        contentDescription = null
                    )
                },
                checked = lightsOn,
                onCheckedChange = onLightsOnToggled
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = if (lightsOn) "Lights On" else "Lights Off",
                fontSize = 14.sp,
                fontFamily = NunitoMedium,
                color = if (lightsOn) {
                    Color.White
                } else Text500
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun LoginPreview() {
    Login(
        modifier = Modifier.padding(16.dp),
        lightsOn = false,
        onForgotClicked = {

        },
        onSignInClicked = {

        },
        onLightsOnToggled = {

        }
    )
}