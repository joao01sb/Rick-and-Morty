package com.app.rickandmorty.data.local.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.rickandmorty.domain.models.CharacterLocation
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: CharacterLocation?,
    val location: CharacterLocation,
    val image: String?,
    val episode: List<String>,
    val url: String,
    val created: String,
)