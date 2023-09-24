package com.gabniel.valorantapp_compose.presenter.screen.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabniel.valorantapp_compose.R
import com.gabniel.valorantapp_compose.presenter.screen.favorite.component.AgentGrid
import com.gabniel.valorantapp_compose.presenter.ui.theme.ValorantAppComposeTheme

@Composable
fun FavoriteScreen(
    navigateBack: () -> Unit,
) {
    FavoriteContent(navigateBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteContent(
    navigateBack: () -> Unit,
) {
    val items = (1..15).toList()

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
            AgentGrid(items = items)
        }
    }
}

@Preview
@Composable
fun FavoritePreview() {
    ValorantAppComposeTheme {
        FavoriteContent {}
    }
}