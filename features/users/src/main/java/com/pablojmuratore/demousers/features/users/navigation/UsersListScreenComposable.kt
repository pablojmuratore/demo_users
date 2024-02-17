package com.pablojmuratore.demousers.features.users.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pablojmuratore.demousers.features.users.R
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.features.users.ui.screens.UsersListScreen
import com.pablojmuratore.demousers.features.users.viewmodels.UsersListViewModel

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.usersListScreenComposable(
    onUserClicked: (user: User) -> Unit = {}
) {
    composable(
        route = UsersNavigation.Screens.UsersListScreen.route
    ) {
        val viewModel = hiltViewModel<UsersListViewModel>()

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(id = R.string.users)) })
            }
        ) { paddingValues ->
            UsersListScreen(
                modifier = Modifier.padding(paddingValues),
                users = viewModel.users.collectAsStateWithLifecycle().value,
                onUserClicked = onUserClicked
            )
        }
    }
}
