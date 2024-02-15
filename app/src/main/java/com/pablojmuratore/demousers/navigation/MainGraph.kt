package com.pablojmuratore.demousers.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.pablojmuratore.demousers.ui.screens.mainScreenComposable

fun NavGraphBuilder.mainGraph(
    navController: NavHostController
) {
    navigation(
        route = MainNavigation.Graphs.MAIN_GRAPH.route,
        startDestination = MainNavigation.Screens.MainScreen.buildRoute()
    ) {
        mainScreenComposable()
    }
}
