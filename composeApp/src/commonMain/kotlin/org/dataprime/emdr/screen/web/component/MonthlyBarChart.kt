package org.dataprime.emdr.screen.web.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.inter
import org.dataprime.emdr.theme.Neutral200
import org.dataprime.emdr.theme.Primary300
import org.dataprime.emdr.theme.Text300
import org.dataprime.emdr.theme.Text400
import org.dataprime.emdr.util.roundedChartMax
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MonthlyBarChart(
    values: List<Float>,
    modifier: Modifier = Modifier
) {

    val textMeasurer = rememberTextMeasurer()

    val maxValue = roundedChartMax(values)

    val nonComposableInterRegular = FontFamily(
        Font(
            resource = Res.font.inter,
            weight = FontWeight.W400
        )
    )

    val maxValueWidth = textMeasurer.measure(
        text = AnnotatedString(maxValue.toString()),
        style = TextStyle(
            color = Text300,
            fontSize = 12.sp,
            fontFamily = nonComposableInterRegular
        )
    ).size.width

    val months = listOf(
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    )

    Box(modifier = modifier.padding(16.dp)) {
        Canvas(modifier = Modifier.fillMaxSize()) {

            val chartHeight = size.height * 0.85f
            val labelAreaHeight = size.height * 0.1f

            val barWidth = size.width / 24f
            val space = barWidth * 0.8f

            /* ─── Grid lines ─── */
            val gridLines = 5
            val gridLineStep = chartHeight / gridLines

            repeat(gridLines + 1) { i ->
                val y = chartHeight - (i * gridLineStep)

                // ─── Grid line ───
                drawLine(
                    color = Neutral200,
                    start = Offset(maxValueWidth.toFloat(), y),
                    end = Offset(size.width, y),
                    strokeWidth = 1.dp.toPx()
                )

                // ─── Value label (Ex: $0 – $1000) ───
                val value = (maxValue / gridLines) * i
                val label = if (value == 0f) "0" else "$${value.toInt()}"

                val textLayout = textMeasurer.measure(
                    text = AnnotatedString(label),
                    style = TextStyle(
                        color = Text300,
                        fontSize = 12.sp,
                        fontFamily = nonComposableInterRegular
                    )
                )

                drawText(
                    textLayout,
                    topLeft = Offset(
                        x = 0f,
                        y = y - textLayout.size.height / 2
                    )
                )
            }

            /* ─── Bars ─── */
            values.forEachIndexed { index, value ->

                val barHeight = (value / maxValue) * chartHeight
                val x = (maxValueWidth * 1.25f) + index * (barWidth + space)

                val radius = 8.dp.toPx()

                val top = chartHeight - barHeight
                val right = x + barWidth

                val path = Path().apply {
                    moveTo(x, chartHeight) // bottom-left
                    lineTo(x, top + radius) // up left side

                    // top-left rounded corner
                    quadraticTo(
                        x, top,
                        x + radius, top
                    )

                    lineTo(right - radius, top) // top edge

                    // top-right rounded corner
                    quadraticTo(
                        right, top,
                        right, top + radius
                    )

                    lineTo(right, chartHeight) // down right side
                    close()
                }

                drawPath(
                    path = path,
                    color = Primary300
                )
            }

            months.forEachIndexed { index, month ->
                val textLayout = textMeasurer.measure(
                    text = AnnotatedString(month),
                    style = TextStyle(
                        color = Text400,
                        fontSize = 12.sp,
                        fontFamily = nonComposableInterRegular
                        )
                    )

                val x = (maxValueWidth * 1.25f) + index * (barWidth + space) +
                        barWidth / 2 -
                        textLayout.size.width / 2

                drawText(
                    textLayout,
                    topLeft = Offset(
                        x,
                        chartHeight + (labelAreaHeight / 2)
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChartPreview() {
    MonthlyBarChart(
        values = listOf(
            700f, 850f, 550f, 750f, 550f, 820f,
            700f, 750f, 700f, 780f, 850f, 650f
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    )

}
