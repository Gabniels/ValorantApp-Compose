package com.gabniel.valorantapp_compose.domain.repository.favorite_agent

import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteAgentRepository {
    suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity)
    suspend fun deleteFavoriteAgent(uuid: String)
    fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>>
}