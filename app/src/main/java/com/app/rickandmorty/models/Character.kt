package com.app.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Character(
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
//    val episode: List<String>?
) : java.io.Serializable