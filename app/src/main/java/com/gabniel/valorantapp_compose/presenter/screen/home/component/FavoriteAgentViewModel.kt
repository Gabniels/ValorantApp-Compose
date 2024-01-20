package com.gabniel.valorantapp_compose.presenter.screen.home.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.FavoriteAgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.GetAllFavoriteAgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.GetFavAgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteAgentViewModel @Inject constructor(
    private val favoriteAgentUseCase: FavoriteAgentUseCase,
    private val getAllFavoriteAgentUseCase: GetFavAgentUseCase
) : ViewModel() {

    fun insertFavoriteAgent(agent: FavoriteAgentEntity) {
        viewModelScope.launch {
            favoriteAgentUseCase.insertFavoriteAgentUseCase.invoke(agent)
        }
    }

    fun getAllFavoriteAgent() {
        viewModelScope.launch {
            getAllFavoriteAgentUseCase.getAllFavoriteAgentUseCase().collect {
            }
        }
    }

}
