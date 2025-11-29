package org.dataprime.emdr

import androidx.compose.runtime.Composable
import org.dataprime.emdr.platform.PlatformCategory
import org.dataprime.emdr.platform.getCategory
import org.dataprime.emdr.screen.mobile.MobileApp
import org.dataprime.emdr.screen.web.WebApp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    if (getCategory() == PlatformCategory.WEB) WebApp() else MobileApp()
}