package com.gabniel.valorantapp_compose.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gabniel.valorantapp_compose.data.network.AgentModel

@Entity(tableName = "favorite_agent")
data class FavoriteAgentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uuid: String,
    val displayName: String?,
    val description: String?,
    val displayIcon: String?,
    val fullPortrait: String?,
    val background: String?
)
//) {
//    companion object{
//        fun transformToAgentModel(input: FavoriteAgentEntity): AgentModel {
//            return AgentModel(
//                uuid = input.uuid,
//                displayName = input.displayName,
//                description = input.description,
//                displayIcon = input.displayIcon,
//                fullPortrait = input.fullPortrait,
//                background = input.background,
//            )
//        }
//    }
//}
