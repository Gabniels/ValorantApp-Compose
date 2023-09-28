package com.gabniel.valorantapp_compose.data.db

import com.gabniel.valorantapp_compose.data.db.dao.AgentDao
import com.gabniel.valorantapp_compose.data.db.dao.FavoriteAgentDao
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val agentDao: AgentDao,
    private val favoriteAgentDao: FavoriteAgentDao
) {
    fun getAllAgent(): Flow<List<AgentEntity>> = agentDao.getAllAgent()

    suspend fun insertAgent(agentList: List<AgentEntity>) = agentDao.insertAgent(agentList)

    suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity) = favoriteAgentDao.insertFavoriteAgent(agent)

    fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>> = favoriteAgentDao.getAllFavoriteAgent()
}