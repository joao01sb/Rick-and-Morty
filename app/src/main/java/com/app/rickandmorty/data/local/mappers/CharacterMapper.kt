package com.app.rickandmorty.data.local.mappers

import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.remote.dto.CharacterDto
import com.app.rickandmorty.domain.models.Character

fun CharacterEntity.toCharacter() = Character(
    id= id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin,
    location = location,
    image = image,
    episode = episode
)

fun CharacterDto.toCharacterEntity() = CharacterEntity(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin,
    location = location,
    image = image,
    episode = episode,
    url = url,
    created = created
)