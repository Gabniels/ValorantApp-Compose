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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gabniel.valorantapp_compose.data.network.AgentModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun AgentPager(
    modifier: Modifier,
    listState: PagerState,
    items: List<AgentModel>,
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
                contentDescription = "",
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
                    .graphicsLayer(
                        scaleX = boxSize,
                        scaleY = boxSize
                    )
                    .padding(16.dp)
                    .clickable {
                        clicked = !clicked
                    },
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "${items[index].fullPortrait}",
                    contentDescription = "agent image",
                    contentScale = ContentScale.FillHeight
                )
                if (clicked) {
                    AgentCard(item = items[index])
                } else {
                }
            }
        }
    }


}