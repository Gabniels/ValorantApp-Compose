package com.gabniel.valorantapp_compose.di

import com.gabniel.valorantapp_compose.data.local.AgentDao
import com.gabniel.valorantapp_compose.data.local.FavoriteAgentDao
import com.gabniel.valorantapp_compose.data.source.agent.AgentLocalDataSource
import com.gabniel.valorantapp_compose.data.source.favorite_agent.FavoriteAgentLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideAgentLocalDataSource(agentDao: AgentDao) = AgentLocalDataSource(agentDao)

    @Provides
    @Singleton
    fun provideFavoriteAgentLocalDataSource(favoriteAgentDao: FavoriteAgentDao) =
        FavoriteAgentLocalDataSource(favoriteAgentDao)
}