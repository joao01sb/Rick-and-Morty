package com.app.rickandmorty.domain.models

import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.local.entitys.FavoriteCharacterEntity
import com.app.rickandmorty.domain.models.Character
import java.util.Date

data class FavoriteCharacter(
    val id: Int,
    val name: String?,
    val status: String?,
    val species: String?,
    val gender: String?,
    val origin: CharacterLocation,
    val location: CharacterLocation,
    val image: String?,
    val episode: List<String>?
)