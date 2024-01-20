package com.gabniel.valorantapp_compose.domain.usecase.favorite_agent

import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.domain.repository.favorite_agent.FavoriteAgentRepository
import kotlinx.coroutines.flow.Flow

class InsertFavoriteAgentUseCase(
    private val favoriteAgentRepository: FavoriteAgentRepository,
) {
    suspend operator fun invoke(agent: FavoriteAgentEntity) {
        return favoriteAgentRepository.insertFavoriteAgent(agent)
    }
}

data class FavoriteAgentUseCase(
    val insertFavoriteAgentUseCase: InsertFavoriteAgentUseCase
)