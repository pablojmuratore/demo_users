package com.pablojmuratore.demousers.navigation

class MainNavigation {
    enum class Graphs(val route: String) {
        MAIN_GRAPH("main_graph")
    }

    sealed class Screens {
        data object MainScreen : Screens() {
            const val route = "main_screen"

            fun buildRoute() = route
        }
    }
}