package com.gabniel.valorantapp_compose.presenter.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gabniel.valorantapp_compose.presenter.components.LoadingIcon
import com.gabniel.valorantapp_compose.presenter.screen.home.component.AgentPager
import com.gabniel.valorantapp_compose.presenter.screen.home.component.FavoriteAgentViewModel
import com.gabniel.valorantapp_compose.presenter.screen.home.component.FavoriteDialog
import com.gabniel.valorantapp_compose.presenter.ui.theme.ValorantAppComposeTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    state: HomeUiState,
    navigateToFavorite: () -> Unit,
) {
    var stateFavorite by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(1000)
        stateFavorite = true
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { contentPadding ->
        if (state.isLoading) {
            LoadingIcon()
        }
        if (!state.isLoading && state.agents.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .padding(contentPadding)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                AgentPager(
                    modifier = Modifier.fillMaxSize(),
                    listState = rememberPagerState(),
                    items = state.agents,
                )
                FavoriteDialog(
                    isVisible = stateFavorite,
                    navigateToFavorite = {
                        navigateToFavorite()
                    }
                )
            }
        }
        if (!state.isLoading && !state.isError) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.message ?: "",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun HomePreview() {
    ValorantAppComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primary
        ) {
//            HomeScreen(
//                state = HomeUiState(),
//                navigateToFavorite = {},
//            )
        }
    }
}