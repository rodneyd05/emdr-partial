package org.dataprime.emdr.screen.web.super_admin.therapist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.*
import org.dataprime.emdr.screen.web.sample.sampleTherapistLists
import org.dataprime.emdr.screen.web.web_model.Filter
import org.dataprime.emdr.screen.web.web_model.Plan
import org.dataprime.emdr.screen.web.web_model.TherapistClientFilter
import org.dataprime.emdr.theme.*
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Therapist() {

    var therapistFilterExpanded by remember {
        mutableStateOf(false)
    }

    var filterExpanded by remember {
        mutableStateOf(false)
    }

    var selectedTherapistClientFilterItem by remember {
        mutableStateOf(TherapistClientFilter.entries.first())
    }

    var selectedItem by remember {
        mutableStateOf(Filter.entries.first())
    }

    var isFilterCustomDate by remember {
        mutableStateOf(false)
    }

    var keyword by remember {
        mutableStateOf("")
    }

    val density = LocalDensity.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(40.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically
        ) {

            var filterTextFieldWidthPx by remember { mutableStateOf(0) }
            val widthDp = with(density) {
                filterTextFieldWidthPx.toDp()
            }

            ExposedDropdownMenuBox(
                modifier = Modifier.onGloballyPositioned {
                    filterTextFieldWidthPx = it.size.width
                },
                expanded = therapistFilterExpanded,
                onExpandedChange = {
                    therapistFilterExpanded = !therapistFilterExpanded
                }
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor(
                            type = ExposedDropdownMenuAnchorType.PrimaryNotEditable
                        ),
                    readOnly = true,
                    leadingIcon = {
                        Image(
                            imageVector = vectorResource(Res.drawable.filter_lines),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Image(
                            imageVector = vectorResource(if (therapistFilterExpanded) Res.drawable.up else Res.drawable.down),
                            contentDescription = null
                        )
                    },
                    colors = OutlinedTextFieldColor,
                    value = "Filters${
                        if (selectedTherapistClientFilterItem == TherapistClientFilter.ALL) "" else {
                            ": " + selectedTherapistClientFilterItem.label
                        }
                    }",
                    onValueChange = {

                    }
                )

                ExposedDropdownMenu(
                    containerColor = Color.White,
                    expanded = therapistFilterExpanded,
                    onDismissRequest = {
                        therapistFilterExpanded = false
                    }
                ) {
                    TherapistClientFilter.entries.forEach {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = it.label,
                                    fontFamily = InterRegular,
                                    fontSize = 16.sp,
                                    color = Text500
                                )
                            },
                            onClick = {
                                selectedTherapistClientFilterItem = it
                                therapistFilterExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            ExposedDropdownMenuBox(
                modifier = Modifier.onGloballyPositioned {
                    filterTextFieldWidthPx = it.size.width
                },
                expanded = filterExpanded,
                onExpandedChange = {
                    filterExpanded = !filterExpanded
                }
            ) {

                OutlinedTextField(
                    modifier = Modifier
                        .menuAnchor(
                            type = ExposedDropdownMenuAnchorType.PrimaryNotEditable
                        ),
                    readOnly = true,
                    leadingIcon = {
                        Image(
                            imageVector = vectorResource(Res.drawable.calendar),
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        Image(
                            imageVector = vectorResource(if (filterExpanded) Res.drawable.up else Res.drawable.down),
                            contentDescription = null
                        )
                    },
                    colors = OutlinedTextFieldColor,
                    value = selectedItem.label,
                    onValueChange = {

                    }
                )

                ExposedDropdownMenu(
                    containerColor = Color.White,
                    expanded = filterExpanded,
                    onDismissRequest = {
                        filterExpanded = false
                    }
                ) {
                    Filter.entries.forEach {
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = it.label,
                                    fontFamily = InterRegular,
                                    fontSize = 16.sp,
                                    color = Text500
                                )
                            },
                            onClick = {
                                isFilterCustomDate = it == Filter.CUSTOM
                                selectedItem = it
                                filterExpanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            if (isFilterCustomDate) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(widthDp)
                        .clip(RoundedCornerShape(4.dp))
                        .border(width = 1.dp, color = Gray600, shape = RoundedCornerShape(4.dp))
                        .background(Color.White)
                        .padding(vertical = 12.dp, horizontal = 14.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            colorFilter = ColorFilter.tint(Text600),
                            imageVector = vectorResource(Res.drawable.calendar),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            text = "Select Dates",
                            fontFamily = InterRegular,
                            fontSize = 16.sp,
                            color = Text600
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            OutlinedTextField(
                modifier = Modifier.width(widthDp),
                singleLine = true,
                colors = OutlinedTextFieldColor,
                leadingIcon = {
                    Image(
                        imageVector = vectorResource(Res.drawable.search_md),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text(
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        text = "Search",
                        fontFamily = InterRegular,
                        fontSize = 16.sp,
                        color = Text200
                    )
                },
                value = keyword,
                onValueChange = {
                    keyword = it
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = Gray600, shape = RoundedCornerShape(8.dp))
        ) {

            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Neutral100),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 24.dp)
                        .weight(0.34f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "First and last name",
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


                    Text(
                        modifier = Modifier
                            .width(200.dp),
                        textAlign = TextAlign.Center,
                        text = "Subscription plan",
                        fontFamily = InterMedium,
                        fontSize = 12.sp,
                        color = Text400
                    )

                    Row(modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 24.dp)
                        .weight(0.22f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = "Subscription start date",
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

                    Row(modifier = Modifier
                        .padding(vertical = 12.dp, horizontal = 24.dp)
                        .weight(0.22f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = "Next renewal date",
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

                HorizontalDivider(color = Gray600)
            }

            items(sampleTherapistLists) {

                val fullName = "${it.firstName} ${it.lastName}"

                val subscriptionBackground = when (it.subscriptionPlan) {
                    Plan.Basic -> Primary50
                    Plan.Premium -> Green50
                }

                val subscriptionFontColor = when (it.subscriptionPlan) {
                    Plan.Basic -> Primary700
                    Plan.Premium -> Green800
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 24.dp)
                            .weight(0.34f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        text = fullName,
                        fontFamily = InterMedium,
                        fontSize = 12.sp,
                        color = Text400
                    )

                    Box(
                        modifier = Modifier
                            .width(200.dp)
                            .padding(vertical = 16.dp, horizontal = 24.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = subscriptionBackground),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 2.dp, horizontal = 8.dp),
                            text = it.subscriptionPlan.name,
                            textAlign = TextAlign.Center,
                            fontFamily = InterMedium,
                            fontSize = 12.sp,
                            color = subscriptionFontColor
                        )
                    }

                    Text(
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 24.dp)
                            .weight(0.22f),
                        text = it.subscriptionStartDate,
                        fontFamily = InterMedium,
                        fontSize = 12.sp,
                        color = Text400
                    )
                    Text(
                        modifier = Modifier
                            .padding(vertical = 12.dp, horizontal = 24.dp)
                            .weight(0.22f),
                        text = it.nextRenewalDate,
                        fontFamily = InterMedium,
                        fontSize = 12.sp,
                        color = Text400
                    )
                }

                HorizontalDivider(color = Gray500)
            }


        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
fun TherapistPreview() {
    Therapist()
}