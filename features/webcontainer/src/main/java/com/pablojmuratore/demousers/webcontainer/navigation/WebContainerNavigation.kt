package com.pablojmuratore.demousers.webcontainer.navigation

class WebContainerNavigation {
    enum class Graphs(val route: String) {
        WEB_CONTAINER_GRAPH("web_container_graph")
    }

    sealed class Screens {
        data object WebContainerScreen : Screens() {
            const val PARAM_URL = "param_url"
            const val route = "web_container_screen/{$PARAM_URL}"

            fun buildRoute(url: String = ""): String {
                return route.replace("{$PARAM_URL}", url)
            }
        }
    }
}