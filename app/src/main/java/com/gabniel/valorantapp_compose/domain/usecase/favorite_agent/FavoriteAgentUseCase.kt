package com.gabniel.valorantapp_compose.domain.usecase.favorite_agent

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

class GetAllFavoriteAgentUseCase(
    private val favoriteAgentRepository: FavoriteAgentRepository,
) {
    operator fun invoke(): Flow<List<FavoriteAgentEntity>> {
        return favoriteAgentRepository.getAllFavoriteAgent()
    }
}

data class FavoriteAgentUseCase(
    val insertFavoriteAgentUseCase: InsertFavoriteAgentUseCase,
    val getAllFavoriteAgentUseCase: GetAllFavoriteAgentUseCase
)