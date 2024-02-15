package com.pablojmuratore.demousers.ui.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pablojmuratore.demousers.navigation.MainNavigation

fun NavGraphBuilder.mainScreenComposable() {
    composable(
        route = MainNavigation.Screens.MainScreen.route,
        arguments = listOf()
    ) {
        MainScreen()
    }
}
