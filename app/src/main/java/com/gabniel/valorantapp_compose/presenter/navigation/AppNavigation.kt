package com.gabniel.valorantapp_compose.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gabniel.valorantapp_compose.presenter.screen.favorite.FavoriteAgentViewModel
import com.gabniel.valorantapp_compose.presenter.screen.favorite.FavoriteScreen
import com.gabniel.valorantapp_compose.presenter.screen.home.HomeScreen
import com.gabniel.valorantapp_compose.presenter.screen.home.HomeViewModel

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController, startDestination = Routes.Home.route
    ) {
        composable(route = Routes.Home.route) {
            HomeScreenNavigation(navHostController)
        }
        composable(route = Routes.Favorite.route) {
            FavoriteScreenNavigation(navHostController)
        }
    }
}

@Composable
fun HomeScreenNavigation(navHostController: NavHostController) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()
    val favoriteAgentViewModel: FavoriteAgentViewModel = hiltViewModel()
    val favoriteState by favoriteAgentViewModel.getData.collectAsState()

    HomeScreen(
        state = state,
        favoriteState = favoriteState,
        navigateToFavorite = { navHostController.navigate(Routes.Favorite.route) }
    ) {
        favoriteAgentViewModel.insertFavoriteAgent(it)
    }
}

@Composable
fun FavoriteScreenNavigation(navHostController: NavHostController) {
    val viewModel: FavoriteAgentViewModel = hiltViewModel()
    val state by viewModel.getData.collectAsState()

    FavoriteScreen(
        state = state,
        onClicked = {
            viewModel.deleteFavoriteAgent(it.uuid)
        }
    ) {
        navHostController.navigateUp()
    }
}