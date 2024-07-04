package com.gabniel.valorantapp_compose.presenter.screen.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gabniel.valorantapp_compose.R
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity.Companion.mapping
import com.gabniel.valorantapp_compose.presenter.ui.theme.ValorantAppComposeTheme

@Composable
fun AgentCard(
    item: AgentModel,
    isVisible: Boolean,
    onAddedToFavorite: (FavoriteAgentEntity) -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideInVertically(),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)) + slideOutVertically()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF272727).copy(alpha = 0.8f)
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = item.displayIcon,
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.displayName.toString(),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            color = Color.White, fontFamily = FontFamily(
                                Font(
                                    R.font.valorant_font, weight = FontWeight.SemiBold
                                )
                            )
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.icon_bookmarked),
                        contentDescription = "",
                        modifier = Modifier
                            .size(32.dp)
                            .clickable {
                                onAddedToFavorite(mapping(item))
                            }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = item.description.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White, textAlign = TextAlign.Justify
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AgentCardPreview() {
    ValorantAppComposeTheme {
        AgentCard(
            item = AgentModel(
                uuid = "e370fa57-4757-3604-3648-499e1f642d3f",
                displayName = "Jetpack Compose",
                description = "Jetpack Compose is ...",
                displayIcon = "https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/displayicon.png",
                fullPortrait = "https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/fullportrait.png",
                background = "https://media.valorant-api.com/agents/e370fa57-4757-3604-3648-499e1f642d3f/background.png",
                emptyList()
            ),
            isVisible = true,
            onAddedToFavorite = {}
        )
    }
}