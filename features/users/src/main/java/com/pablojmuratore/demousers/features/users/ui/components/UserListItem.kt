package com.pablojmuratore.demousers.features.users.ui.components

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

@Composable
fun UserListItem(
    name: String,
    email: String? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
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
@Composable
fun PreviewUserListItem() {
    UserListItem(
        name = "User 1"
    )
}

@Preview(apiLevel = 33)
@Composable
fun PreviewUserListItemWithEmail() {
    UserListItem(
        name = "User 1",
        email = "user1@users.com"
    )
}
