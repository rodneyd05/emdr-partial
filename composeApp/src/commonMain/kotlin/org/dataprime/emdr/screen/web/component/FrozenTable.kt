package org.dataprime.emdr.screen.web.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.dots_vertical
import io.github.oikvpqya.compose.fastscroller.HorizontalScrollbar
import io.github.oikvpqya.compose.fastscroller.VerticalScrollbar
import io.github.oikvpqya.compose.fastscroller.defaultScrollbarStyle
import io.github.oikvpqya.compose.fastscroller.rememberScrollbarAdapter
import org.dataprime.emdr.data.model.ClientModel
import org.dataprime.emdr.data.model.TherapistModel
import org.dataprime.emdr.data.model.User
import org.dataprime.emdr.screen.web.sample.sampleTherapistList
import org.dataprime.emdr.screen.web.web_model.Plan
import org.dataprime.emdr.screen.web.web_model.therapistHeaders
import org.dataprime.emdr.theme.Gray500
import org.dataprime.emdr.theme.Gray600
import org.dataprime.emdr.theme.Green50
import org.dataprime.emdr.theme.Green800
import org.dataprime.emdr.theme.InterMedium
import org.dataprime.emdr.theme.InterRegular
import org.dataprime.emdr.theme.Neutral100
import org.dataprime.emdr.theme.NunitoSemiBold
import org.dataprime.emdr.theme.Primary50
import org.dataprime.emdr.theme.Primary700
import org.dataprime.emdr.theme.Text100
import org.dataprime.emdr.theme.Text200
import org.dataprime.emdr.theme.Text300
import org.dataprime.emdr.theme.Text500
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun FrozenTable(
    headers: List<String>,
    data: List<User>
) {

    val verticalScroll = rememberScrollState()
    val horizontalScroll = rememberScrollState()

    val headerHeight = 40.dp
    val rowHeight = 66.dp

    val nameColumnWidth = 323.dp
    val cellWidth = 200.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .border(width = 1.dp, color = Gray600, shape = RoundedCornerShape(8.dp))

    ) {
        // ───────── HEADER ROW ─────────
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                .background(Neutral100),
        ) {
            // ── TOP-LEFT (frozen)
            Box(
                modifier = Modifier
                    .width(nameColumnWidth)
                    .height(headerHeight),
                contentAlignment = Alignment.CenterStart
            ) {
                TableHeadingWithSort(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp, horizontal = 24.dp),
                    text = headers.first()
                )
            }

            // ── TOP-RIGHT (horizontal scroll only)
            Row(
                modifier = Modifier
                    .weight(1f)
                    .horizontalScroll(horizontalScroll)
            ) {
                headers.drop(n = 1).forEach { header ->
                    TableHeadingWithSort(
                        modifier = Modifier
                            .width(cellWidth)
                            .height(headerHeight)
                            .padding(vertical = 12.dp, horizontal = 24.dp),
                        text = header
                    )
                }
            }

            // This one needs to be frozen
            // More actions header
            Box(
                modifier = Modifier
                    .width(72.dp)
                    .height(headerHeight),
                contentAlignment = Alignment.CenterStart
            ) {
                // Blank
            }

        }

        HorizontalDivider(color = Gray600)

        // ───────── BODY ─────────
        Box(modifier = Modifier.weight(1f)) {

            Row(modifier = Modifier.fillMaxSize()) {
                // ── MIDDLE-LEFT (vertical scroll only)
                Column(modifier = Modifier.verticalScroll(verticalScroll)) {
                    data.forEach { item ->
                        Column(
                            modifier = Modifier
                                .width(nameColumnWidth)
                                .height(rowHeight)
                        ) {

                            Row(modifier = Modifier.fillMaxSize()) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 16.dp, horizontal = 24.dp),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Text(
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontFamily = InterMedium,
                                        fontSize = 14.sp,
                                        color = Text500,
                                        text = when (item) {
                                            is TherapistModel -> "${item.firstName} ${item.lastName}"
                                            is ClientModel -> item.userId
                                            else -> ""
                                        }
                                    )
                                }

                                VerticalDivider(color = Gray500)
                            }

                            HorizontalDivider(color = Gray500)
                        }

                    }
                }

                // ── MIDDLE-RIGHT (horizontal + vertical scroll)
                Box(modifier = Modifier.weight(1f)) {

                    Column(
                        modifier = Modifier
                            .horizontalScroll(horizontalScroll)
                            .verticalScroll(verticalScroll)
                    ) {

                        data.forEach { item ->

                            val subscriptionBackground = when (item.subscriptionPlan) {
                                Plan.Basic -> Primary50
                                Plan.Premium -> Green50
                            }

                            val subscriptionFontColor = when (item.subscriptionPlan) {
                                Plan.Basic -> Primary700
                                Plan.Premium -> Green800
                            }

                            val contentSize = when(item) {
                                is TherapistModel -> 6
                                is ClientModel -> 7
                                else -> 2
                            }

                            Column(
                                modifier = Modifier
                                    .height(rowHeight)
                                    .width(cellWidth * contentSize)
                            ) {

                                Row(modifier = Modifier.fillMaxSize()) {
                                    when (item) {
                                        is TherapistModel -> {
                                            PlanDataCell(
                                                text = item.subscriptionPlan.name,
                                                subscriptionBackground = subscriptionBackground,
                                                subscriptionFontColor = subscriptionFontColor
                                            )
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.subscriptionStartDate)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.nextRenewalDate)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.address)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.businessName)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.signupDate)
                                            VerticalDivider(color = Gray500)
                                        }

                                        is ClientModel -> {

                                            OtherDataCell(text = item.userName)
                                            VerticalDivider(color = Gray500)

                                            PlanDataCell(
                                                text = item.subscriptionPlan.name,
                                                subscriptionBackground = subscriptionBackground,
                                                subscriptionFontColor = subscriptionFontColor
                                            )
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(text = item.linkedTherapist)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(
                                                text = if (item.logShared) {
                                                    "Shared"
                                                } else "Not shared"
                                            )
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.subscriptionStartDate)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.nextRenewalDate)
                                            VerticalDivider(color = Gray500)

                                            OtherDataCell(item.signupDate)
                                            VerticalDivider(color = Gray500)
                                        }

                                        else -> Unit
                                    }
                                }

                                HorizontalDivider(color = Gray500)
                            }
                        }
                    }

                    HorizontalScrollbar(
                        adapter = rememberScrollbarAdapter(horizontalScroll),
                        modifier = Modifier.align(Alignment.BottomCenter),
                        style = defaultScrollbarStyle()
                    )
                }

                //This one needs to be frozen
                Column(modifier = Modifier.verticalScroll(verticalScroll)) {
                    data.forEach { therapist ->

                        Column(
                            modifier = Modifier
                                .width(72.dp)
                                .height(rowHeight)
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .border(width = 1.dp, color = Gray500),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Image(
                                    imageVector = vectorResource(Res.drawable.dots_vertical),
                                    contentDescription = null
                                )
                            }


                            HorizontalDivider(color = Gray500)
                        }
                    }
                }
            }

            VerticalScrollbar(
                adapter = rememberScrollbarAdapter(verticalScroll),
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                style = defaultScrollbarStyle()
            )
        }

        HorizontalDivider(color = Gray500)

        //Bottom
        Row(
            modifier = Modifier
                .height(63.dp)
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 16.dp)
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier,
                text = "Page 1 of 5",
                fontFamily = InterMedium,
                fontSize = 14.sp,
                color = Text200
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(
                    width = 1.dp, color = Gray600
                ),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier,
                    text = "Previous",
                    fontFamily = NunitoSemiBold,
                    fontSize = 14.sp,
                    color = Text100
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(
                    width = 1.dp, color = Gray600
                ),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier,
                    text = "Next",
                    fontFamily = NunitoSemiBold,
                    fontSize = 14.sp,
                    color = Text500
                )
            }
        }
    }
}

@Composable
fun PlanDataCell(
    text: String,
    subscriptionBackground: Color,
    subscriptionFontColor: Color
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(66.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(subscriptionBackground)
                .padding(vertical = 2.dp, horizontal = 8.dp),
            text = text,
            textAlign = TextAlign.Center,
            fontFamily = InterMedium,
            fontSize = 12.sp,
            color = subscriptionFontColor
        )
    }
}

@Composable
fun OtherDataCell(text: String) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(66.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            text = text,
            fontFamily = InterRegular,
            fontSize = 14.sp,
            color = Text300
        )
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
fun FrozenTablePreview() {
    FrozenTable(
        headers = therapistHeaders,
        data = sampleTherapistList
    )
}
