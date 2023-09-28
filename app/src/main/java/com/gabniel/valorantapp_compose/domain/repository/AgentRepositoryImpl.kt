package com.gabniel.valorantapp_compose.domain.repository

import com.gabniel.valorantapp_compose.data.NetworkBoundResource
import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.db.LocalDataSource
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import com.gabniel.valorantapp_compose.data.network.AgentResponse
import com.gabniel.valorantapp_compose.data.network.ApiResponse
import com.gabniel.valorantapp_compose.data.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AgentRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : AgentRepository {
    override fun getAllAgent(): Flow<Resource<List<AgentModel>>> =
        object : NetworkBoundResource<List<AgentModel>, AgentResponse>() {
            override fun loadFromDB(): Flow<List<AgentModel>> {
                return localDataSource.getAllAgent().map {
                    AgentEntity.transformToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<AgentResponse>> {
                return remoteDataSource.getAllAgent()
            }

            override suspend fun saveCallResult(data: AgentResponse) {
                val dataList = AgentResponse.transformToEntities(data)
                localDataSource.insertAgent(dataList)
            }

            override fun shouldFetch(data: List<AgentModel>?): Boolean {
                return true
            }
        }.asFlow()

    override suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity) {
       return localDataSource.insertFavoriteAgent(agent)
    }

    override fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>> {
        return localDataSource.getAllFavoriteAgent()
    }


}