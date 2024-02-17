package com.pablojmuratore.demousers.features.users.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablojmuratore.demousers.DemoUsersTheme

@Composable
fun UserDetailScreen(
    modifier: Modifier = Modifier,
    userName: String,
    phone: String? = null,
    website: String? = null
) {
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = userName,
                style = TextStyle(
                    fontSize = 24.sp
                )
            )
            Text("phone: $phone")
            Text("website: ${website}")
        }
    }
}


@Preview(apiLevel = 33)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, apiLevel = 33)
@Composable
fun PreviewUserDetailScreen() {
    DemoUsersTheme(dynamicColor = false) {
        UserDetailScreen(
            userName = "user1",
            phone = "12345678",
            website = "http://www.user1.com/"
        )
    }
}