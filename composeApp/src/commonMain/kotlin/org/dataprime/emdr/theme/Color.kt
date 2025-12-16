package org.dataprime.emdr.theme

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Text500 = Color(0xFF2E2E2E)
val Text300 = Color(0xFF737373)
val Text100 = Color(0xFFBEBEBE)
val Gray600 = Color(0xFFE2E4E5)
val Gray500 = Color(0xFFF8FAFC)
val Primary700 = Color(0xFF3566A0)
val Primary500 = Color(0xFF4A90E2)
val Primary300 = Color(0xFF86B5EC)
val Primary200 = Color(0xFFACCCF2)

val OutlinedTextFieldColor @Composable get() = OutlinedTextFieldDefaults.colors(
    unfocusedBorderColor = Gray600,
    focusedBorderColor = Primary300,
    unfocusedContainerColor = Color.White,
    focusedContainerColor = Color.White
)

val CheckBoxColor @Composable get() = CheckboxDefaults.colors(
    checkmarkColor = Gray600,
    uncheckedColor = Gray600,
    checkedColor = Primary300
)

val ButtonColor @Composable get() = ButtonDefaults.buttonColors(
    disabledContainerColor = Primary200,
    containerColor = Primary500
)

val SwitchColor @Composable get() = SwitchDefaults.colors(
    uncheckedTrackColor = Gray600,
    checkedTrackColor = Primary500,
    uncheckedThumbColor = Color.White,
    checkedThumbColor = Color.White,
    uncheckedBorderColor = Color.Transparent
)