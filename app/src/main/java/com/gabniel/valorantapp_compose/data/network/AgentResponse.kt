package com.gabniel.valorantapp_compose.data.network

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgentResponse(
    val status: Int,
    val data: List<AgentItem>,
) : Parcelable {
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
    @PrimaryKey
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?,
) {
    companion object {

        fun mapping(item: AgentModel): FavoriteAgentEntity {
            return FavoriteAgentEntity(
                uuid = item.uuid,
                displayName = item.displayName,
                description = item.description,
                displayIcon = item.displayIcon,
                fullPortrait = item.fullPortrait,
                background = item.background
            )
        }
    }
}

@Parcelize
data class AgentItem(
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?,
    val backgroundGradientColors: List<String>?,
) : Parcelable