package com.gabniel.valorantapp_compose.data.network

import retrofit2.http.GET

interface ApiService {

    @GET("agents")
    suspend fun getAllAgent(): AgentResponse
}