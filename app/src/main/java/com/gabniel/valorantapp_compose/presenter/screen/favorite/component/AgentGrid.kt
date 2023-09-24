package com.gabniel.valorantapp_compose.presenter.screen.favorite.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabniel.valorantapp_compose.R
import com.gabniel.valorantapp_compose.presenter.ui.theme.ValorantAppComposeTheme
import kotlin.random.Random

@Composable
fun AgentGrid(
    items: List<Int>,
) {
    var selectedAgent by remember {
        mutableStateOf<Int?>(null)
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(4)
    ) {
        items(items) {
            val isSelected = it == selectedAgent
            AgentGridItem(isSelected = isSelected,
                selected = {
                    selectedAgent = if (isSelected) null else it
                }
            )
        }
    }
}

@Composable
fun AgentGridItem(
    isSelected: Boolean,
    selected: () -> Unit,
) {
    val color by remember {
        mutableStateOf(
            Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
        )
    }

    Image(
        painter = painterResource(id = R.drawable.valorant_logo),
        contentDescription = "logo image",
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

// test
@Preview(showBackground = true)
@Composable
fun AgentGridPreview() {
    ValorantAppComposeTheme {
        AgentGrid((1..10).toList())
    }
}