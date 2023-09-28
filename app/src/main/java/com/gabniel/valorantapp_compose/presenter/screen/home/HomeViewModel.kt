package com.gabniel.valorantapp_compose.presenter.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.domain.usecase.AgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.FavoriteAgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val agentUseCase: AgentUseCase,
    private val favoriteAgentUserCase: FavoriteAgentUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        getAllAgent()
    }

    private fun getAllAgent() {
        viewModelScope.launch {
            agentUseCase.getAllAgentUseCase().collect { response ->
                when (response) {
                    is Resource.Success -> {
                        val data = response.data
                        _uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                agents = data ?: emptyList()
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                isError = true,
                                agents = emptyList(),
                                message = response.message
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _uiState.update { state ->
                            state.copy(
                                isLoading = true,
                                isError = false,
                                agents = emptyList()
                            )
                        }
                    }
                }
            }
        }
    }

    fun insertFavoriteAgent(agent: FavoriteAgentEntity) {
        viewModelScope.launch {
          favoriteAgentUserCase.insertFavoriteAgent.invoke(agent)
        }
    }
}