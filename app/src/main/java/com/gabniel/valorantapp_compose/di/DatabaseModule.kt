package com.gabniel.valorantapp_compose.di

import android.app.Application
import androidx.room.Room
import com.gabniel.valorantapp_compose.data.db.AgentDao
import com.gabniel.valorantapp_compose.data.db.AgentDatabase
import com.gabniel.valorantapp_compose.data.db.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application) = Room.databaseBuilder(
        application,
        AgentDatabase::class.java,
        "agent_db"
    ).build()

    @Provides
    @Singleton
    fun provideDao(database: AgentDatabase): AgentDao {
        return database.agentDao()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(agentDao: AgentDao) = LocalDataSource(agentDao)
}