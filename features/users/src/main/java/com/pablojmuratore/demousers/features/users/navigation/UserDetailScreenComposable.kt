package com.pablojmuratore.demousers.features.users.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pablojmuratore.demousers.corecompose.components.SimpleBackTopAppBar
import com.pablojmuratore.demousers.features.users.ui.screens.UserDetailScreen
import com.pablojmuratore.demousers.features.users.viewmodels.UserDetailViewModel

fun NavGraphBuilder.userDetailScreenComposable(
    onBackClicked: () -> Unit = {}
) {
    composable(
        route = UsersNavigation.Screens.UserDetailScreen.route,
        arguments = listOf(
            navArgument(UsersNavigation.Screens.UserDetailScreen.PARAM_USER_ID) { type = NavType.IntType }
        )
    ) {
        val userId = it.arguments?.getInt(UsersNavigation.Screens.UserDetailScreen.PARAM_USER_ID) ?: 0
        val viewModel = hiltViewModel<UserDetailViewModel>()
        val user = viewModel.user.collectAsStateWithLifecycle().value

        if (user == null) {
            viewModel.loadUserInfo(userId)
        }

        Scaffold(
            topBar = {
                SimpleBackTopAppBar(onBackClicked = onBackClicked)
            }
        ) { paddingValues ->
            UserDetailScreen(
                modifier = Modifier.padding(paddingValues),
                userName = user?.userName ?: "",
                phone = user?.phone,
                website = user?.website
            )
        }
    }
}
