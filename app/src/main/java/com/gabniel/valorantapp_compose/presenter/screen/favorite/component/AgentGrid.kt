package com.gabniel.valorantapp_compose.presenter.screen.favorite.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gabniel.valorantapp_compose.R
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import kotlin.random.Random

@Composable
fun AgentGrid(
    modifier: Modifier = Modifier,
    onClicked: (FavoriteAgentEntity) -> Unit,
    items: List<FavoriteAgentEntity>,
) {
    var selectedAgent by remember {
        mutableStateOf<FavoriteAgentEntity?>(null)
    }

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(4)
    ) {
        items(items) {
            val isSelected = it == selectedAgent
            AgentGridItem(
                item = it,
                isSelected = isSelected,
                selected = {
                    selectedAgent = if (isSelected) null else it
                    onClicked(it)
                }
            )
        }
    }
}

@Composable
fun AgentGridItem(
    item: FavoriteAgentEntity,
    isSelected: Boolean,
    selected: () -> Unit,
) {
    val color by remember {
        mutableStateOf(
            Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
        )
    }

    AsyncImage(
        model =
        if (item.displayIcon?.isNotEmpty() == true) item.displayIcon
        else R.drawable.valorant_logo,
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                selected()
            }
            .size(85.dp)
            .border(
                width = if (isSelected) 3.dp else 2.dp,
                color = if (isSelected) color else Color(0xFFFF8C8C),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp)
    )
}