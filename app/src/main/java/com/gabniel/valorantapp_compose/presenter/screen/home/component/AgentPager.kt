package com.gabniel.valorantapp_compose.presenter.screen.home.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.presenter.ui.theme.ValorantAppComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AgentPager(
    modifier: Modifier,
    listState: PagerState,
    items: List<AgentModel>,
    onAddedToFavorite: (FavoriteAgentEntity) -> Unit,
) {
    VerticalPager(
        modifier = modifier,
        state = listState,
        pageCount = Int.MAX_VALUE
    ) {
        val pageOffset = (listState.currentPage - it) + listState.currentPageOffsetFraction
        var clicked by remember { mutableStateOf(false) }

        val boxSize by animateFloatAsState(
            targetValue = if (pageOffset != 0.0f) 0.5f else 1f,
            animationSpec = tween(500),
            label = "box size"
        )

        val fadeInOutAlpha by rememberInfiniteTransition(label = "").animateFloat(
            initialValue = 0f,
            targetValue = 0.5f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1500, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "fade in out alpha"
        )

        val index = it % items.size

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = "${items[index].background}",
                contentDescription = "image background",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(fadeInOutAlpha)
            )
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        clicked = !clicked
                    }
                    .graphicsLayer(
                        scaleX = boxSize,
                        scaleY = boxSize
                    )
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "${items[index].fullPortrait}",
                    contentDescription = "image agent",
                    contentScale = ContentScale.FillHeight
                )
                AgentCard(
                    item = items[index],
                    isVisible = clicked,
                    onAddedToFavorite = { value ->
                        onAddedToFavorite(value)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun AgentPagerPreview() {
    ValorantAppComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.primary
        ) {
            AgentPager(
                modifier = Modifier.fillMaxSize(),
                listState = rememberPagerState(),
                items = listOf(
                    AgentModel(
                        uuid = "1",
                        displayName = "Jetpack Compose",
                        description = "Jetpack Compose",
                        displayIcon = "",
                        fullPortrait = "",
                        background = "",
                        emptyList()
                    )
                )
            ) {}
        }
    }
}