package com.pablojmuratore.demousers.features.users.navigation

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
        usersListScreenComposable()
    }
}