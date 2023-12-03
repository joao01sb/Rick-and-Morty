package com.app.rickandmorty.data.local.mappers

import com.app.rickandmorty.data.local.entitys.FavoriteCharacterEntity
import com.app.rickandmorty.domain.models.FavoriteCharacter

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