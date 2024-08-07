package com.gabniel.valorantapp_compose.presenter.screen.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gabniel.valorantapp_compose.R
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.presenter.screen.favorite.component.AgentGrid

@Composable
fun FavoriteScreen(
    onClicked: (FavoriteAgentEntity) -> Unit,
    state: FavoriteUiState,
    navigateBack: () -> Unit,
) {
    FavoriteContent(
        state = state, navigateBack = navigateBack,
        onClicked = {
            onClicked(it)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteContent(
    onClicked: (FavoriteAgentEntity) -> Unit,
    state: FavoriteUiState,
    navigateBack: () -> Unit,
) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(it)
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_arrow_back),
                contentDescription = "icon back",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navigateBack() }
            )
            Spacer(modifier = Modifier.height(16.dp))
            if (state.agents.isNotEmpty()) {
                AgentGrid(
                    items = state.agents,
                    onClicked = { value ->
                        onClicked(value)
                    }
                )
            } else {
                Box(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(id = R.drawable.valorant_logo),
                        contentDescription = "icon back",
                        modifier = Modifier
                            .size(200.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}