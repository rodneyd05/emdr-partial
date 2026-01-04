package org.dataprime.emdr.screen.web.super_admin

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.arrow_up_right
import emdrcompanion.composeapp.generated.resources.emdr_text
import emdrcompanion.composeapp.generated.resources.eye_black
import emdrcompanion.composeapp.generated.resources.eye_white
import org.dataprime.emdr.screen.web.component.Heading
import org.dataprime.emdr.screen.web.web_model.AdminTab
import org.dataprime.emdr.theme.BalooMedium
import org.dataprime.emdr.theme.NunitoSemiBold
import org.dataprime.emdr.theme.Primary50
import org.dataprime.emdr.theme.Primary500
import org.dataprime.emdr.theme.Text500
import org.dataprime.emdr.util.TextIcon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SuperAdmin(
    lightsOn: Boolean,
    content: @Composable (AdminTab) -> Unit
) {

    var selectedTab by remember { mutableStateOf(AdminTab.DASHBOARD) }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Column(
            modifier = Modifier
                .width(293.dp)
                .fillMaxHeight()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.height(64.dp),
                        painter = painterResource(if (lightsOn) {
                            Res.drawable.eye_white
                        } else Res.drawable.eye_black),
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Image(
                            colorFilter = ColorFilter.tint(
                                if (lightsOn) Color.White else Text500
                            ),
                            modifier = Modifier.height(36.dp),
                            painter = painterResource(Res.drawable.emdr_text),
                            contentDescription = null
                        )

                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "COMPANION",
                            fontFamily = BalooMedium,
                            fontSize = 20.sp,
                            color = if (lightsOn) Color.White else Text500
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {

                AdminTab.entries.forEach { tab ->


                    /*
                    In Compose Multiplatform (especially on Web/Wasm), the default indication (the ripple) handles both the "hover" state and the "pressed" state.
                    When you set indication = null, you lose both.

                    implement a custom background logic that detects the hover state manually while keeping indication = null to suppress the ripple.
                     */

                    val interactionSource = remember { MutableInteractionSource() }
                    val isHovered by interactionSource.collectIsHoveredAsState()

                    val hoverOverlay = if (isHovered) Color.Black.copy(alpha = 0.05f) else Color.Transparent
                    val animatedHoverColor by animateColorAsState(targetValue = hoverOverlay)

                    val selected = selectedTab == tab

                    val backgroundColor by animateColorAsState(
                        targetValue = if (selected) Primary500 else Color.Transparent,
                        animationSpec = tween(durationMillis = 500),
                        label = "RowBackgroundAnimation"
                    )

                    val contentColor by animateColorAsState(
                        targetValue = if (lightsOn) {
                            Color.White
                        } else {
                            if (selected) Color.White else Text500
                        },
                        animationSpec = tween(durationMillis = 500),
                        label = "ContentColorAnimation"
                    )

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                onClick = {
                                    selectedTab = tab
                                }
                            )
                            .fillMaxWidth()
                            .background(backgroundColor)
                            .background(animatedHoverColor)
                            .height(46.dp)
                            .padding(vertical = 12.dp, horizontal = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            colorFilter = ColorFilter.tint(contentColor),
                            imageVector = vectorResource(tab.icon),
                            contentDescription = null
                        )

                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = tab.label,
                            fontFamily = NunitoSemiBold,
                            fontSize = 16.sp,
                            color = contentColor
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }

                Spacer(modifier = Modifier.weight(1f))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Primary50
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp, horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextIcon(
                        firstName = "First",
                        lastName = "Last",
                        size = 32.dp
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(start = 8.dp),
                        text = "First Last",
                        fontFamily = NunitoSemiBold,
                        fontSize = 16.sp,
                        color = Text500
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        imageVector = vectorResource(Res.drawable.arrow_up_right),
                        contentDescription = null
                    )
                }
            }

        }

        Column(modifier = Modifier
            .fillMaxSize()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(Color.White)
        ) {

            Heading(user = "User")

            content(selectedTab)
        }
    }
}