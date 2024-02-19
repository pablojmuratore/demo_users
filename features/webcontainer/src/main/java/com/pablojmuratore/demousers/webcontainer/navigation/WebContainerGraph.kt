package com.pablojmuratore.demousers.webcontainer.navigation

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.webContainerGraph(
    navController: NavHostController
) {
    navigation(
        route = WebContainerNavigation.Graphs.WEB_CONTAINER_GRAPH.route,
        startDestination = WebContainerNavigation.Screens.WebContainerScreen.buildRoute()
    ) {
        webContainerScreenComposable(
            onBackClicked = {
                if (navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED) {
                    navController.popBackStack()
                }
            }
        )
    }
}
