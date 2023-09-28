package com.gabniel.valorantapp_compose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabniel.valorantapp_compose.data.db.dao.AgentDao
import com.gabniel.valorantapp_compose.data.db.dao.FavoriteAgentDao
import com.gabniel.valorantapp_compose.data.db.entity.FavoriteAgentEntity
import com.gabniel.valorantapp_compose.data.network.AgentEntity

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