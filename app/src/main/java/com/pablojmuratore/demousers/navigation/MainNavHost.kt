package com.pablojmuratore.demousers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pablojmuratore.demousers.features.users.navigation.UsersNavigation
import com.pablojmuratore.demousers.features.users.navigation.usersGraph

@Composable
fun MainNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = UsersNavigation.Graphs.USERS_GRAPH.route
    ) {
        usersGraph(navController = navController)
    }
}