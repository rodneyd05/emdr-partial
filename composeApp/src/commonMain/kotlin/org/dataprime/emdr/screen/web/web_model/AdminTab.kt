package org.dataprime.emdr.screen.web.web_model

import emdrcompanion.composeapp.generated.resources.Res
import emdrcompanion.composeapp.generated.resources.bar_chart_square_03
import emdrcompanion.composeapp.generated.resources.face_content
import emdrcompanion.composeapp.generated.resources.grid_01
import emdrcompanion.composeapp.generated.resources.users_01
import emdrcompanion.composeapp.generated.resources.users_check
import org.jetbrains.compose.resources.DrawableResource

enum class AdminTab(
    val icon: DrawableResource,
    val label: String
) {
    DASHBOARD(icon = Res.drawable.bar_chart_square_03, label = "Dashboard"),
    THERAPISTS(icon = Res.drawable.users_01, label = "Therapists"),
    CLIENTS(icon = Res.drawable.users_check, label = "Clients"),
    MOOD_CATEGORY(icon = Res.drawable.grid_01, label = "Mood Category"),
    MOODS(icon = Res.drawable.face_content, label = "Moods")
}