package org.dataprime.emdr.screen.web

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.dataprime.emdr.screen.web.login.Login
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun WebApp() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Login()
    }
}