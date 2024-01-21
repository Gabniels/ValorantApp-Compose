package com.gabniel.valorantapp_compose.domain.repository.agent

import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.network.AgentModel
import kotlinx.coroutines.flow.Flow

interface AgentRepository {
    fun getAllAgent(): Flow<Resource<List<AgentModel>>>
}