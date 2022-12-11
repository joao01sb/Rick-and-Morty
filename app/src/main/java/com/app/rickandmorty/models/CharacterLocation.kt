package com.app.rickandmorty.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterLocation(
    val name: String,
    val url: String
) : java.io.Serializable