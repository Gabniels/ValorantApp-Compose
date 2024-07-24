package com.gabniel.valorantapp_compose.domain.repository.agent

import com.gabniel.valorantapp_compose.data.NetworkBoundResource
import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.AgentResponse
import com.gabniel.valorantapp_compose.data.network.ApiResponse
import com.gabniel.valorantapp_compose.data.source.agent.AgentLocalDataSource
import com.gabniel.valorantapp_compose.data.source.agent.AgentRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private val agentLocalDataSource: AgentLocalDataSource,
    private val agentRemoteDataSource: AgentRemoteDataSource,
) : AgentRepository {
    override fun getAllAgent(): Flow<Resource<List<AgentModel>>> =
        object : NetworkBoundResource<List<AgentModel>, AgentResponse>() {
            override fun loadFromDB(): Flow<List<AgentModel>> {
                return agentLocalDataSource.getAllAgent().map {
                    AgentEntity.transformToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<AgentResponse>> {
                return agentRemoteDataSource.getAllAgent()
            }

            override suspend fun saveCallResult(data: AgentResponse) {
                val dataList = AgentResponse.transformToEntities(data)
                agentLocalDataSource.insertAgent(dataList)
            }

            override fun shouldFetch(data: List<AgentModel>?): Boolean {
                return true
            }
        }.asFlow()
}