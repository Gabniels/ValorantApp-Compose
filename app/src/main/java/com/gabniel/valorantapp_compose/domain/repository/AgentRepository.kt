package com.gabniel.valorantapp_compose.domain.repository

import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import kotlinx.coroutines.flow.Flow

interface AgentRepository {
    fun getAllAgent(): Flow<Resource<List<AgentModel>>>

    suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity)

    fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>>
}