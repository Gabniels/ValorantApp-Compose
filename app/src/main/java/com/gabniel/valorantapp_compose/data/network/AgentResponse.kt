package com.gabniel.valorantapp_compose.data.network

import androidx.room.Entity
import androidx.room.PrimaryKey

data class AgentResponse(
    val status: Int,
    val data: List<AgentItem>,
) {
    companion object {
        fun transformToEntities(agentResponse: AgentResponse): List<AgentEntity> {
            val agentList = ArrayList<AgentEntity>()
            agentResponse.data.map {
                val agent = AgentEntity(
                    id = 0,
                    uuid = it.uuid,
                    displayName = it.displayName,
                    description = it.description,
                    displayIcon = it.displayIcon,
                    fullPortrait = it.fullPortrait,
                    background = it.background
                )
                agentList.add(agent)
            }
            return agentList
        }
    }
}

data class AgentModel(
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?,
    val backgroundGradientColors: List<String>?,
)

@Entity(tableName = "agent")
data class AgentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?,
) {
    companion object {
        fun transformToDomain(dataList: List<AgentEntity>): List<AgentModel> {
            val agentList = ArrayList<AgentModel>()
            dataList.map {
                val agent = AgentModel(
                    uuid = it.uuid,
                    displayName = it.displayName,
                    description = it.description,
                    displayIcon = it.displayIcon,
                    fullPortrait = it.fullPortrait,
                    background = it.background,
                    backgroundGradientColors = emptyList()
                )
                agentList.add(agent)
            }
            return agentList
        }
    }
}

@Entity(tableName = "favorite_agent")
data class FavoriteAgentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?,
) {
    companion object {
        fun transformToDomain(dataList: List<FavoriteAgentEntity>): List<AgentModel> {
            val agentList = ArrayList<AgentModel>()
            dataList.map {
                val agent = AgentModel(
                    uuid = it.uuid,
                    displayName = it.displayName,
                    description = it.description,
                    displayIcon = it.displayIcon,
                    fullPortrait = it.fullPortrait,
                    background = it.background,
                    backgroundGradientColors = emptyList()
                )
                agentList.add(agent)
            }
            return agentList
        }
    }
}

data class AgentItem(
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?,
    val backgroundGradientColors: List<String>?,
)