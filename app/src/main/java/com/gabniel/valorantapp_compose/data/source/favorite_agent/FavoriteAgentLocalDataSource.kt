package com.gabniel.valorantapp_compose.data.source.favorite_agent

import com.gabniel.valorantapp_compose.data.Resource
import com.gabniel.valorantapp_compose.data.db.FavoriteAgentDao
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteAgentLocalDataSource @Inject constructor(
    private val favoriteAgentDao: FavoriteAgentDao,
) {

    suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity) =
        favoriteAgentDao.insertFavoriteAgent(agent)

    fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>> = favoriteAgentDao.getAllFavoriteAgent()

}