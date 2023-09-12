package com.gabniel.valorantapp_compose.presenter.screen.home

import com.gabniel.valorantapp_compose.data.network.AgentModel

data class HomeUiState(
    val isLoading: Boolean,
    val isError: Boolean,
    val agents: List<AgentModel>,
    val message: String?,
) {
    constructor() : this(
        isLoading = true,
        isError = false,
        agents = mutableListOf(),
        message = null
    )
}