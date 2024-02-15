package com.pablojmuratore.demousers.features.users.navigation

class UsersNavigation {
    enum class Graphs(val route: String) {
        USERS_GRAPH("users_graph")
    }

    sealed class Screens {
        data object UsersListScreen : Screens() {
            const val route = "users_list_screen"

            fun buildRoute() = route
        }
    }
}