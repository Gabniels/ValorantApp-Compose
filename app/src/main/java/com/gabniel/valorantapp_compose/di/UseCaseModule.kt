package com.gabniel.valorantapp_compose.di

import com.gabniel.valorantapp_compose.domain.repository.agent.AgentRepository
import com.gabniel.valorantapp_compose.domain.repository.favorite_agent.FavoriteAgentRepository
import com.gabniel.valorantapp_compose.domain.usecase.agent.AgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.agent.GetAllAgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.DeleteFavoriteAgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.FavoriteAgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.GetAllFavoriteAgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.favorite_agent.InsertFavoriteAgentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(
        agentRepository: AgentRepository,
    ) = AgentUseCase(getAllAgentUseCase = GetAllAgentUseCase(agentRepository))

    @Provides
    @Singleton
    fun provideFavoriteAgentUseCase(
        favoriteAgentRepository: FavoriteAgentRepository,
    ) = FavoriteAgentUseCase(
        insertFavoriteAgentUseCase = InsertFavoriteAgentUseCase(favoriteAgentRepository),
        getAllFavoriteAgentUseCase = GetAllFavoriteAgentUseCase(favoriteAgentRepository),
        deleteFavoriteAgentUseCase = DeleteFavoriteAgentUseCase(favoriteAgentRepository),
    )
}