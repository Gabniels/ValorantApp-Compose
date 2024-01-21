package com.gabniel.valorantapp_compose.di

import com.gabniel.valorantapp_compose.data.source.agent.AgentLocalDataSource
import com.gabniel.valorantapp_compose.data.source.agent.AgentRemoteDataSource
import com.gabniel.valorantapp_compose.data.source.favorite_agent.FavoriteAgentLocalDataSource
import com.gabniel.valorantapp_compose.domain.repository.agent.AgentRepository
import com.gabniel.valorantapp_compose.domain.repository.agent.AgentRepositoryImpl
import com.gabniel.valorantapp_compose.domain.repository.favorite_agent.FavoriteAgentRepository
import com.gabniel.valorantapp_compose.domain.repository.favorite_agent.FavoriteAgentRepositoryImpl
import com.gabniel.valorantapp_compose.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        agentRemoteDataSource: AgentRemoteDataSource,
        agentLocalDataSource: AgentLocalDataSource,
        appExecutors: AppExecutors,
    ): AgentRepository =
        AgentRepositoryImpl(
            agentLocalDataSource = agentLocalDataSource,
            agentRemoteDataSource = agentRemoteDataSource,
        )

    @Provides
    @Singleton
    fun provideFavoriteAgentRepository(
        localDataSource: FavoriteAgentLocalDataSource,
    ): FavoriteAgentRepository =
        FavoriteAgentRepositoryImpl(localDataSource = localDataSource)


}