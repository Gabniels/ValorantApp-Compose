package com.gabniel.valorantapp_compose.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gabniel.valorantapp_compose.presenter.screen.favorite.FavoriteScreen
import com.gabniel.valorantapp_compose.presenter.screen.home.HomeScreen
import com.gabniel.valorantapp_compose.presenter.screen.home.HomeViewModel

@Composable
fun AppNavigation(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Home.route
    ) {
        composable(route = Routes.Home.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            val state by viewModel.uiState.collectAsState()
            HomeScreen(state = state) {
                navHostController.navigate(Routes.Favorite.route)
            }
        }
        composable(route = Routes.Favorite.route) {
            FavoriteScreen {
                navHostController.popBackStack()
            }
        }
    }
}