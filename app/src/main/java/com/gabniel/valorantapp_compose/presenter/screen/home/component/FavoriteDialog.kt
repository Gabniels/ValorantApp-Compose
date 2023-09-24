package com.gabniel.valorantapp_compose.presenter.screen.home.component

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabniel.valorantapp_compose.R
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.presenter.ui.theme.ValorantAppComposeTheme

@Composable
fun FavoriteDialog(
    isVisible: Boolean,
    navigateToFavorite: () -> Unit,
    items: List<AgentModel>,
) {
    FavoriteDialogContent(
        isVisible = isVisible,
        items = items,
        navigateToFavorite = { navigateToFavorite() }
    )
}

@Composable
fun FavoriteDialogContent(
    isVisible: Boolean,
    items: List<AgentModel>,
    navigateToFavorite: () -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideInVertically(),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)) + slideOutVertically()
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    navigateToFavorite()
                },
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF272727).copy(alpha = 0.5f)
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.valorant_logo),
                    contentDescription = "logo image",
                    modifier = Modifier
                        .size(35.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFFF8C8C).copy(alpha = 0.8f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(6.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = if (items.isNotEmpty()) stringResource(R.string.favorite_is_here)
                    else stringResource(R.string.favorite_is_empty),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FavoriteDialogPreview() {
    ValorantAppComposeTheme {
        FavoriteDialogContent(true, emptyList(), {})
    }
}