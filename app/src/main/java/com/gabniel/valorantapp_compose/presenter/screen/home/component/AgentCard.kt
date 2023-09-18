package com.gabniel.valorantapp_compose.presenter.screen.home.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gabniel.valorantapp_compose.data.network.AgentModel

@Composable
fun AgentCard(item: AgentModel) {

    val position by rememberInfiniteTransition(label = "").animateFloat(
        initialValue = -50f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(tween(2000), RepeatMode.Reverse), label = ""
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .offset(y = position.dp),
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