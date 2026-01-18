package org.dataprime.emdr.screen.web.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.arrow_up
import org.dataprime.emdr.theme.InterMedium
import org.dataprime.emdr.theme.Text400
import org.jetbrains.compose.resources.vectorResource

@Composable
fun TableHeadingWithSort(
    modifier: Modifier = Modifier,
    text: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = text,
            fontFamily = InterMedium,
            fontSize = 12.sp,
            color = Text400
        )

        Image(
            modifier = Modifier.size(16.dp),
            colorFilter = ColorFilter.tint(Text400),
            imageVector = vectorResource(Res.drawable.arrow_up),
            contentDescription = null
        )
    }
}