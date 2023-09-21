package com.gabniel.valorantapp_compose.presenter.navigation

sealed class Routes(
    val route: String,
) {
    object Home : Routes("Home")
    object Favorite : Routes("Favorite")
}
