package com.gabniel.valorantapp_compose.data.source.agent

import com.gabniel.valorantapp_compose.data.db.AgentDao
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AgentLocalDataSource @Inject constructor(
    private val agentDao: AgentDao,
) {
    fun getAllAgent(): Flow<List<AgentEntity>> = agentDao.getAllAgent()

    suspend fun insertAgent(agentList: List<AgentEntity>) = agentDao.insertAgent(agentList)
}