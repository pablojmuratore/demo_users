package com.pablojmuratore.demousers.webcontainer.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pablojmuratore.demousers.corecompose.components.SimpleBackTopAppBar
import com.pablojmuratore.demousers.webcontainer.ui.screens.WebContainerScreen

fun NavGraphBuilder.webContainerScreenComposable(
    onBackClicked: () -> Unit = {}
) {
    composable(
        route = WebContainerNavigation.Screens.WebContainerScreen.route,
        arguments = listOf(
            navArgument(WebContainerNavigation.Screens.WebContainerScreen.PARAM_URL) {
                type = NavType.StringType
            }
        )
    ) {
        val url = it.arguments?.getString(WebContainerNavigation.Screens.WebContainerScreen.PARAM_URL) ?: ""

        Scaffold(
            topBar = { SimpleBackTopAppBar(onBackClicked = onBackClicked) }
        ) { paddingValues ->
            WebContainerScreen(
                modifier = Modifier.padding(paddingValues),
                url = url
            )
        }
    }
}
