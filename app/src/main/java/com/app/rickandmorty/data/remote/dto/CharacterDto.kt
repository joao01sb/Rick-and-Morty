package com.app.rickandmorty.data.remote.dto

import com.app.rickandmorty.domain.models.CharacterLocation
import com.app.rickandmorty.domain.models.Location
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterLocation,
    val location: CharacterLocation,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)