package com.gabniel.valorantapp_compose.domain.usecase

import com.gabniel.valorantapp_compose.data.Resource
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