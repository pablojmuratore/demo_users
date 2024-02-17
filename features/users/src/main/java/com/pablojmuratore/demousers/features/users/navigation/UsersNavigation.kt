package com.pablojmuratore.demousers.features.users.navigation

import com.pablojmuratore.demousers.features.users.models.User

class UsersNavigation {
    enum class Graphs(val route: String) {
        USERS_GRAPH("users_graph")
    }

    sealed class Screens {
        data object UsersListScreen : Screens() {
            const val route = "users_list_screen"

            fun buildRoute() = route
        }

        data object UserDetailScreen : Screens() {
            const val PARAM_USER_ID = "user_id"
            const val route = "user_detail_screen/{$PARAM_USER_ID}"

            fun buildRoute(user: User? = null): String {
                val userId = (user?.id ?: 0).toString()

                return route.replace("{$PARAM_USER_ID}", userId)
            }
        }
    }
}
