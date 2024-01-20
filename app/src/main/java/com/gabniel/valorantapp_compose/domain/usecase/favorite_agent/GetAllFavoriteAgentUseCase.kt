package com.gabniel.valorantapp_compose.domain.usecase.favorite_agent

import com.gabniel.valorantapp_compose.data.db.FavoriteAgentDao
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.domain.repository.favorite_agent.FavoriteAgentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoriteAgentUseCase @Inject constructor(
    private val favoriteAgentRepository: FavoriteAgentRepository
) {

    operator fun invoke(): Flow<List<FavoriteAgentEntity>> {
        return favoriteAgentRepository.getAllFavoriteAgent()
    }
}

data class GetFavAgentUseCase(
    val getAllFavoriteAgentUseCase: GetAllFavoriteAgentUseCase
)
