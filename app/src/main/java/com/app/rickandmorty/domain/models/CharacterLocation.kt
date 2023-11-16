package com.app.rickandmorty.domain.models

import java.io.Serializable

data class CharacterLocation(
    val name: String,
    val url: String
) : Serializable