package org.dataprime.emdr.screen.web.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.arrow_down
import emdrcompanion.composeapp.generated.resources.arrow_up
import emdrcompanion.composeapp.generated.resources.chart_illustration_down
import emdrcompanion.composeapp.generated.resources.chart_illustration_up
import org.dataprime.emdr.screen.web.web_model.Direction
import org.dataprime.emdr.theme.Gray600
import org.dataprime.emdr.theme.Green700
import org.dataprime.emdr.theme.InterMedium
import org.dataprime.emdr.theme.InterSemiBold
import org.dataprime.emdr.theme.Red700
import org.dataprime.emdr.theme.Text400
import org.dataprime.emdr.theme.Text500
import org.jetbrains.compose.resources.vectorResource

@Composable
fun IllustrationCard(
    modifier: Modifier = Modifier,
    heading: String,
    content: String,
    percentage: String,
    direction: Direction
) {
    Surface(
        modifier = modifier
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(8.dp),
        color = Color.White,
        border = BorderStroke(width = 1.dp, color = Gray600)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = heading,
                fontFamily = InterSemiBold,
                fontSize = 16.sp,
                color = Text500
            )

            Row(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.weight(1f)) {


                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        text = content,
                        fontFamily = InterSemiBold,
                        fontSize = 36.sp,
                        color = Text500
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            imageVector = vectorResource(
                                resource = if (direction == Direction.UP) {
                                    Res.drawable.arrow_up
                                } else Res.drawable.arrow_down
                            ),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = percentage,
                            fontFamily = InterMedium,
                            fontSize = 14.sp,
                            color = if (direction == Direction.UP) Green700 else Red700
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = "vs last month",
                            fontFamily = InterMedium,
                            fontSize = 14.sp,
                            color = Text400
                        )
                    }

                }

                Image(
                    modifier = Modifier.align(Alignment.Bottom),
                    imageVector = vectorResource(
                        resource = if (direction == Direction.UP) {
                            Res.drawable.chart_illustration_up
                        } else Res.drawable.chart_illustration_down
                    ),
                    contentDescription = null
                )
            }
        }
    }
}