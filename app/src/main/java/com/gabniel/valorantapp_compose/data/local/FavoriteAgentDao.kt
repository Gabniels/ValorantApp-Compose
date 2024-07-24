package com.gabniel.valorantapp_compose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteAgentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteAgent(agent: FavoriteAgentEntity)

    @Query("SELECT * FROM favorite_agent")
    fun getAllFavoriteAgent(): Flow<List<FavoriteAgentEntity>>

    @Query("DELETE FROM favorite_agent WHERE uuid = :uuid")
    suspend fun deleteFavoriteAgent(uuid: String)
}