package com.gabniel.valorantapp_compose.di

import android.annotation.SuppressLint
import com.gabniel.valorantapp_compose.BuildConfig
import com.gabniel.valorantapp_compose.data.source.agent.AgentLocalDataSource
import com.gabniel.valorantapp_compose.data.network.ApiService
import com.gabniel.valorantapp_compose.data.source.agent.AgentRemoteDataSource
import com.gabniel.valorantapp_compose.domain.repository.agent.AgentRepository
import com.gabniel.valorantapp_compose.domain.repository.agent.AgentRepositoryImpl
import com.gabniel.valorantapp_compose.domain.usecase.agent.AgentUseCase
import com.gabniel.valorantapp_compose.domain.usecase.agent.GetAllAgentUseCase
import com.gabniel.valorantapp_compose.utils.AppExecutors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        return retrofit.client(client).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService) = AgentRemoteDataSource(apiService)

    @SuppressLint("VisibleForTests")
    @Provides
    @Singleton
    fun provideAppExecutors() = AppExecutors(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(3),
        AppExecutors.MainThreadExecutor()
    )
}