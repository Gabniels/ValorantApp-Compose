package com.gabniel.valorantapp_compose.domain.usecase

import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.domain.repository.AgentRepository
import kotlinx.coroutines.flow.Flow

class GetAllAgentUseCase(
    private val agentRepository: AgentRepository,
) {
    operator fun invoke(): Flow<Resource<List<AgentModel>>> {
        return agentRepository.getAllAgent()
    }
}

data class AgentUseCase(
    val getAllAgentUseCase: GetAllAgentUseCase,
)

class InsertFavoriteAgentUseCase(
    private val agentRepository: AgentRepository,
) {
    suspend operator fun invoke(agent: FavoriteAgentEntity) {
        return agentRepository.insertFavoriteAgent(agent)
    }
}

data class GetAllFavoriteAgentUseCase(private val agentRepository: AgentRepository) {
    operator fun invoke(): Flow<List<FavoriteAgentEntity>> {
        return agentRepository.getAllFavoriteAgent()
    }
}

data class FavoriteAgentUseCase(
    val insertFavoriteAgent: InsertFavoriteAgentUseCase,
    val getAllFavoriteAgent: GetAllFavoriteAgentUseCase,
)

