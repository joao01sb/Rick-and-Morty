package com.app.rickandmorty.data.local.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.rickandmorty.domain.models.CharacterLocation
import com.app.rickandmorty.domain.models.FavoriteCharacter
import java.util.Date

@Entity(tableName = "favorite")
data class FavoriteCharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val status: String?,
    val species: String?,
    val gender: String?,
    val origin: CharacterLocation,
    val location: CharacterLocation,
    val image: String?,
    val episode: List<String>?,
)

fun FavoriteCharacterEntity.toFavoriteCharacter() = FavoriteCharacter(
    id,
    name,
    status,
    species,
    gender,
    origin,
    location,
    image,
    episode
)

