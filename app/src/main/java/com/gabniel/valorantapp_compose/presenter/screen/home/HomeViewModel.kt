package com.gabniel.valorantapp_compose.presenter.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.domain.usecase.AgentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val agentUseCase: AgentUseCase,
) : ViewModel() {

    var uiState = MutableStateFlow(HomeUiState())
        private set

    init {
        getAllAgent()
    }

    private fun getAllAgent() {
        viewModelScope.launch {
            agentUseCase.getAllAgentUseCase().collect { response ->
                when (response) {
                    is Resource.Success -> {
                        val data = response.data
                        uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                agents = data ?: emptyList()
                            )
                        }
                    }
                    is Resource.Error -> {
                        uiState.update { state ->
                            state.copy(
                                isLoading = false,
                                isError = true,
                                agents = emptyList(),
                                message = response.message
                            )
                        }
                    }
                    is Resource.Loading -> {
                        uiState.update { state ->
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
}