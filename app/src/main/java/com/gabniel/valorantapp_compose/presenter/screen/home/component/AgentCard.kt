package com.gabniel.valorantapp_compose.presenter.screen.home.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gabniel.valorantapp_compose.data.network.AgentModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AgentCard(item: AgentModel, isVisible: Boolean) {

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(animationSpec = tween(durationMillis = 1000)) + slideInHorizontally(),
        exit = fadeOut(animationSpec = tween(durationMillis = 1000)) + slideOutHorizontally()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF452C8C).copy(alpha = 0.8f))
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = item.displayIcon,
                    contentDescription = "",
                    contentScale = ContentScale.Fit,

                    )
                Text(
                    text = item.displayName.toString(),
                    fontSize = 20.sp,
                    color = Color.White
                )
                Text(
                    text = item.description.toString(),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify,
                    color = Color.White
                )
            }
        }
    }

}