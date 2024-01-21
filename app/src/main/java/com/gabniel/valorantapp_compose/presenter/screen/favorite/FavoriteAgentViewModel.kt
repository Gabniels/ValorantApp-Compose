package com.gabniel.valorantapp_compose.presenter.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.FavoriteAgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteAgentViewModel @Inject constructor(
    private val favoriteAgentUseCase: FavoriteAgentUseCase,
) : ViewModel() {

    fun insertFavoriteAgent(agent: FavoriteAgentEntity) {
        viewModelScope.launch {
            favoriteAgentUseCase.insertFavoriteAgentUseCase.invoke(agent)
        }
    }

    init {
        getAllFavoriteAgent()
    }

    var getData = MutableStateFlow(FavoriteUiState())
        private set

    private fun getAllFavoriteAgent() {
        viewModelScope.launch {
            favoriteAgentUseCase.getAllFavoriteAgentUseCase().collect {
                getData.update { state ->
                    state.copy(
                        agents = it
                    )
                }
            }
        }
    }

}
