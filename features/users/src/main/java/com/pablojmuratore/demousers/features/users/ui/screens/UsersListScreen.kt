package com.pablojmuratore.demousers.features.users.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pablojmuratore.demousers.features.users.R
import com.pablojmuratore.demousers.features.users.datastates.UsersState
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.features.users.ui.components.UsersList

@Composable
fun UsersListScreen(
    modifier: Modifier = Modifier,
    usersState: UsersState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (usersState) {
            is UsersState.Undefined -> {
                Text(stringResource(id = R.string.no_users_information))
            }

            is UsersState.Loading -> {
                Text(stringResource(id = R.string.load_users_information))
            }

            is UsersState.Error -> {
                val errorMessage = usersState.message ?: stringResource(id = R.string.users_information_loading_error)
                Text(errorMessage)
            }

            is UsersState.Loaded -> {
                val users = usersState.users

                UsersList(users = users)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUsersListScreen() {
    val mockUsers = listOf(
        User(1, "user1"),
        User(2, "user2"),
        User(3, "user3"),
        User(4, "user4", "user4@users.com"),
        User(5, "user5")
    )

    UsersListScreen(
        usersState = UsersState.Loaded(users = mockUsers)
    )
}