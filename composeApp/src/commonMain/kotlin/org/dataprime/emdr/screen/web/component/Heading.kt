package org.dataprime.emdr.screen.web.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.dataprime.emdr.theme.InterRegular
import org.dataprime.emdr.theme.InterSemiBold
import org.dataprime.emdr.theme.Text300
import org.dataprime.emdr.theme.Text500

@Composable
fun Heading(user: String) {

    Column(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .padding(top = 40.dp)
    ) {
        Text(
            text = "Welcome back, $user",
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
    }

}