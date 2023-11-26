package com.app.rickandmorty.domain.models

import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.local.entitys.FavoriteCharacterEntity
import com.app.rickandmorty.domain.models.Character

data class FavoriteCharacter(
    val id: Int,
    val name: String?,
    val status: String?,
    val species: String?,
    val gender: String?,
    val origin: String?,
    val location: String?,
    val image: String?,
    val episode: List<String>?
)

fun FavoriteCharacter.toEntity() = FavoriteCharacterEntity(
    id = id,
    status = status,
    name = name,
    species = species,
    gender = gender,
    origin = origin,
    location = location,
    image = image,
    episode = episode
)