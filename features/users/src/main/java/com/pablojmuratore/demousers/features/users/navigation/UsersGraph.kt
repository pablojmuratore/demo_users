package com.pablojmuratore.demousers.features.users.navigation

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.pablojmuratore.demousers.webcontainer.navigation.WebContainerNavigation
import com.pablojmuratore.demousers.webcontainer.navigation.webContainerScreenComposable

fun NavGraphBuilder.usersGraph(
    navController: NavHostController
) {
    navigation(
        route = UsersNavigation.Graphs.USERS_GRAPH.route,
        startDestination = UsersNavigation.Screens.UsersListScreen.buildRoute()
    ) {
        usersListScreenComposable(
            onUserClicked = { user ->
                navController.navigate(UsersNavigation.Screens.UserDetailScreen.buildRoute(user))
            }
        )

        userDetailScreenComposable(
            onBackClicked = {
                if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                    navController.popBackStack()
                }
            },
            onWebsiteClicked = { url ->
                navController.navigate(WebContainerNavigation.Screens.WebContainerScreen.buildRoute(url))
            }
        )

        webContainerScreenComposable(
            onBackClicked = {
                if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                    navController.popBackStack()
                }
            }
        )
    }
}