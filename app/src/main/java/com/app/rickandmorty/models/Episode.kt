package com.app.rickandmorty.models

import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>
)