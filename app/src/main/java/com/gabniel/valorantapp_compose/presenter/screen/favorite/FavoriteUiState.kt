package com.gabniel.valorantapp_compose.presenter.screen.favorite

import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity

data class FavoriteUiState(
    val isLoading: Boolean,
    val isError: Boolean,
    val agents: List<FavoriteAgentEntity>,
    val message: String?,
) {
    constructor() : this(
        isLoading = true,
        isError = false,
        agents = mutableListOf(),
        message = null
    )
}