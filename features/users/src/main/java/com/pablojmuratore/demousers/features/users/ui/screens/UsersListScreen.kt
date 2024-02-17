package com.pablojmuratore.demousers.features.users.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pablojmuratore.demousers.DemoUsersTheme
import com.pablojmuratore.demousers.features.users.R
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.features.users.ui.components.UsersList

@Composable
fun UsersListScreen(
    modifier: Modifier = Modifier,
    users: List<User> = emptyList(),
    onUserClicked: (user: User) -> Unit = {}
) {
    Surface {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (!users.isEmpty()) {
                UsersList(
                    users = users,
                    onUserClicked = onUserClicked
                )
            } else {
                Text(stringResource(id = R.string.no_users_message))
            }
        }
    }
}


@Preview(showBackground = true, apiLevel = 33)
@Preview(showBackground = true, apiLevel = 33, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewUsersListScreen() {
    val mockUsers = listOf(
        User(1, "user1"),
        User(2, "user2"),
        User(3, "user3"),
        User(4, "user4", "user4@users.com"),
        User(5, "user5")
    )

    DemoUsersTheme {
        UsersListScreen(
            users = mockUsers
        )
    }
}