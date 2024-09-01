package com.app.rickandmorty.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterLocation(
    val name: String,
    val url: String
)