package com.gabniel.valorantapp_compose.domain.repository.favorite_agent

import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.source.favorite_agent.FavoriteAgentLocalDataSource
import kotlinx.coroutines.flow.Flow

class FavoriteAgentRepositoryImpl(
    private val localDataSource: FavoriteAgentLocalDataSource,
) : FavoriteAgentRepository {
    override suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity) {
        return localDataSource.insertFavoriteAgent(agent)
    }

    override fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>> {
        return localDataSource.getAllFavoriteAgent()
    }
}