package com.gabniel.valorantapp_compose.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteAgentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity)
//    suspend fun insertFavoriteAgent(agent: AgentModel)

    @Query("SELECT * FROM favorite_agent")
    fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>>

}