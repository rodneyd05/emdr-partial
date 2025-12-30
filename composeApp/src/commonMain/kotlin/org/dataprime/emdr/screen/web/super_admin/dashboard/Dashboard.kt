package org.dataprime.emdr.screen.web.super_admin.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.calendar
import emdrcompanion.composeapp.generated.resources.down
import emdrcompanion.composeapp.generated.resources.up
import org.dataprime.emdr.screen.web.component.IllustrationCard
import org.dataprime.emdr.screen.web.component.MonthlyBarChart
import org.dataprime.emdr.screen.web.web_model.DashboardFilter
import org.dataprime.emdr.screen.web.web_model.Direction
import org.dataprime.emdr.theme.*
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {

    var filterExpanded by remember {
        mutableStateOf(false)
    }

    var selectedItem by remember {
        mutableStateOf(DashboardFilter.entries.first())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(40.dp)
    ) {
        Text(
            text = "Welcome back, User",
            fontFamily = InterSemiBold,
            fontSize = 30.sp,
            color = Text500
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Track, manage and forecast your users and subscribers.",
            fontFamily = InterRegular,
            fontSize = 16.sp,
            color = Text300
        )

        Spacer(modifier = Modifier.height(40.dp))

        ExposedDropdownMenuBox(
            expanded = filterExpanded,
            onExpandedChange = {
                filterExpanded = !filterExpanded
            }
        ) {

            OutlinedTextField(
                modifier = Modifier.menuAnchor(
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
                DashboardFilter.entries.forEach {
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
                            selectedItem = it
                            filterExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            IllustrationCard(
                modifier = Modifier.weight(0.5f),
                heading = "Total revenue",
                content = "$ 612,000.00",
                percentage = "60%",
                direction = Direction.UP
            )

            Spacer(modifier = Modifier.width(20.dp))

            IllustrationCard(
                modifier = Modifier.weight(0.5f),
                heading = "New app subscribers",
                content = "124",
                percentage = "10%",
                direction = Direction.UP
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Surface(
            modifier = Modifier
                .height(304.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            color = Color.White,
            border = BorderStroke(width = 1.dp, color = Gray600)
        ) {
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

        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth()) {

            IllustrationCard(
                modifier = Modifier.weight(0.33f),
                heading = "Total active app users",
                content = "2420",
                percentage = "40%",
                direction = Direction.UP
            )

            Spacer(modifier = Modifier.width(20.dp))

            IllustrationCard(
                modifier = Modifier.weight(0.33f),
                heading = "Total active subscribers",
                content = "121",
                percentage = "20%",
                direction = Direction.UP
            )

            Spacer(modifier = Modifier.width(20.dp))

            IllustrationCard(
                modifier = Modifier.weight(0.33f),
                heading = "New app users",
                content = "80",
                percentage = "20%",
                direction = Direction.DOWN
            )
        }

    }
}

@Preview(showBackground = true, widthDp = 1920, heightDp = 1080)
@Composable
fun DashboardPreview() {
    Dashboard()
}