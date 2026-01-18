package org.dataprime.emdr.screen.web.super_admin.client

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.calendar
import emdrcompanion.composeapp.generated.resources.down
import emdrcompanion.composeapp.generated.resources.filter_lines
import emdrcompanion.composeapp.generated.resources.search_md
import emdrcompanion.composeapp.generated.resources.up
import org.dataprime.emdr.screen.web.component.FrozenTable
import org.dataprime.emdr.screen.web.sample.sampleClientList
import org.dataprime.emdr.screen.web.web_model.Filter
import org.dataprime.emdr.screen.web.web_model.TherapistClientFilter
import org.dataprime.emdr.screen.web.web_model.clientHeaders
import org.dataprime.emdr.theme.Gray600
import org.dataprime.emdr.theme.InterRegular
import org.dataprime.emdr.theme.OutlinedTextFieldColor
import org.dataprime.emdr.theme.Text200
import org.dataprime.emdr.theme.Text500
import org.dataprime.emdr.theme.Text600
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Client() {

    var clientFilterExpanded by remember {
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
                expanded = clientFilterExpanded,
                onExpandedChange = {
                    clientFilterExpanded = !clientFilterExpanded
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
                            imageVector = vectorResource(if (clientFilterExpanded) Res.drawable.up else Res.drawable.down),
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
                    expanded = clientFilterExpanded,
                    onDismissRequest = {
                        clientFilterExpanded = false
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
                                clientFilterExpanded = false
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

        FrozenTable(
            headers = clientHeaders,
            data = sampleClientList
        )
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
fun ClientPreview() {
    Client()
}