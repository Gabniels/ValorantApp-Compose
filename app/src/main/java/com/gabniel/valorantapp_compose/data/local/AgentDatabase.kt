package com.gabniel.valorantapp_compose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabniel.valorantapp_compose.data.network.AgentEntity
import com.gabniel.valorantapp_compose.data.network.FavoriteAgentEntity

@Database(
    entities = [
        AgentEntity::class,
        FavoriteAgentEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class AgentDatabase : RoomDatabase() {
    abstract fun agentDao(): AgentDao
    abstract fun favoriteAgentDao(): FavoriteAgentDao
}