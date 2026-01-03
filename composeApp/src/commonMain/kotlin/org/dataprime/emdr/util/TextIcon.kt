package org.dataprime.emdr.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dataprime.emdr.theme.InterSemiBold
import org.dataprime.emdr.theme.Primary50
import org.dataprime.emdr.theme.Primary700
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TextIcon(firstName: String, lastName: String, size: Dp) {
    val first = firstName.firstOrNull()?.toString()?.uppercase() ?: "A"
    val last = lastName.firstOrNull()?.toString()?.uppercase() ?: "A"

    val fontSize = (size.value * 0.4).sp

    Box(
        modifier = Modifier
            .size(size)
            .background(color = Primary50, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = first,
                fontSize = fontSize,
                fontFamily = InterSemiBold,
                color = Primary700,
                textAlign = TextAlign.Center
            )

            Text(
                text = last,
                fontSize = fontSize,
                fontFamily = InterSemiBold,
                color = Primary700,
                textAlign = TextAlign.Center
            )
        }

    }
}

@Preview
@Composable
private fun TextIconPreview() {
    TextIcon(firstName = "First", lastName = "Last", 24.dp)
}