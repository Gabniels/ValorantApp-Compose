package com.gabniel.valorantapp_compose.data.source.agent

import com.gabniel.valorantapp_compose.data.network.AgentResponse
import com.gabniel.valorantapp_compose.data.network.ApiResponse
import com.gabniel.valorantapp_compose.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AgentRemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) {
    fun getAllAgent(): Flow<ApiResponse<AgentResponse>> {
        return flow {
            try {
                val response = apiService.getAllAgent()
                val data = response.data
                if (data.isNotEmpty()) emit(ApiResponse.Success(response))
                else emit(ApiResponse.Empty)
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}

