package org.dataprime.emdr.screen.web.change_password

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.check
import emdrcompanion.composeapp.generated.resources.eye_black
import emdrcompanion.composeapp.generated.resources.eye_white
import org.dataprime.emdr.theme.ButtonColor
import org.dataprime.emdr.theme.Gray500
import org.dataprime.emdr.theme.InterSemiBold
import org.dataprime.emdr.theme.NunitoBold
import org.dataprime.emdr.theme.NunitoSemiBold
import org.dataprime.emdr.theme.OutlinedTextFieldColor
import org.dataprime.emdr.theme.Text100
import org.dataprime.emdr.theme.Text300
import org.dataprime.emdr.theme.Text500
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ChangePassword(
    modifier: Modifier = Modifier,
    lightsOn: Boolean,
    onUpdatePasswordClicked: () -> Unit
) {

    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }

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
            text = "Set up new password",
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
            text = "Update your password to restore account access.",
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
                text = "New Password",
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
                value = newPassword,
                onValueChange = {
                    newPassword = it
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(
                        color = Text100
                    ),
                    imageVector = vectorResource(Res.drawable.check),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "8 characters or more",
                    fontSize = 16.sp,
                    fontFamily = NunitoBold,
                    color = Text100
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(16.dp),
                    colorFilter = ColorFilter.tint(
                        color = Text100
                    ),
                    imageVector = vectorResource(Res.drawable.check),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "No whitespace",
                    fontSize = 16.sp,
                    fontFamily = NunitoBold,
                    color = Text100
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "Confirm New Password",
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
                value = confirmNewPassword,
                onValueChange = {
                    confirmNewPassword = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonColor,
                enabled = newPassword.isNotEmpty() && confirmNewPassword.isNotEmpty(),
                onClick = onUpdatePasswordClicked,
            ) {
                Text(
                    text = "Update Password",
                    fontSize = 16.sp,
                    fontFamily = NunitoSemiBold,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun ChangePasswordPreview() {
    ChangePassword(
        modifier = Modifier.padding(16.dp),
        lightsOn = false,
        onUpdatePasswordClicked = {

        }
    )
}