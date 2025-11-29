package org.dataprime.emdr.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.inter
import emdrcompanion.composeapp.generated.resources.nunito
import org.jetbrains.compose.resources.Font

val InterSemiBold @Composable get() = FontFamily(
    Font(
        resource = Res.font.inter,
        weight = FontWeight.W600
    )
)

val NunitoBold @Composable get() = FontFamily(
    Font(
        resource = Res.font.nunito,
        weight = FontWeight.W700
    )
)

val NunitoSemiBold @Composable get() = FontFamily(
    Font(
        resource = Res.font.nunito,
        weight = FontWeight.W600
    )
)

val NunitoMedium @Composable get() = FontFamily(
    Font(
        resource = Res.font.nunito,
        weight = FontWeight.W500
    )
)