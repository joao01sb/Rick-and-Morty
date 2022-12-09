package com.app.rickandmorty.models

import kotlinx.serialization.Serializable

@Serializable
data class Personagem(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterLocation,
    val location: CharacterLocation,
    val image: String,
    val episode: List<String>
)