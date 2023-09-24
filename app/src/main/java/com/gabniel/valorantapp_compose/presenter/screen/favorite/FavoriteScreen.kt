package com.gabniel.valorantapp_compose.presenter.screen.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabniel.valorantapp_compose.R
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
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
                .padding(it)
                .padding(16.dp),
        ) {
            Text(
                text = "Favorite Screen",
                style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White
                ),
                modifier = Modifier.align(Alignment.Center)
            )
            Image(
                painter = painterResource(id = R.drawable.icon_arrow_back),
                contentDescription = "icon back",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navigateBack() }
            )
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