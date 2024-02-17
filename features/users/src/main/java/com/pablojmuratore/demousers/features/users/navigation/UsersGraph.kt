package com.pablojmuratore.demousers.features.users.navigation

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

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
            }
        )
    }
}