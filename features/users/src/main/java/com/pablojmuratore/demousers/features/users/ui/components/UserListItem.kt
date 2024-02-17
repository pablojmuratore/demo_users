package com.pablojmuratore.demousers.features.users.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pablojmuratore.demousers.DemoUsersTheme

@Composable
fun UserListItem(
    name: String,
    email: String? = null,
    onClicked: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClicked() }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(vertical = 4.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                )
            )

            email?.let {
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = email,
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}


@Preview(apiLevel = 33)
@Preview(apiLevel = 33, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListItem() {
    DemoUsersTheme {
        UserListItem(
            name = "User 1"
        )
    }
}

@Preview(apiLevel = 33)
@Preview(apiLevel = 33, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUserListItemWithEmail() {
    DemoUsersTheme {
        UserListItem(
            name = "User 1",
            email = "user1@users.com"
        )
    }
}
