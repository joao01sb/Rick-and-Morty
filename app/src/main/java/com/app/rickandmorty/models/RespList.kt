package com.app.rickandmorty.models

import kotlinx.serialization.Serializable

@Serializable
data class RespList<T>(
    val info: Info,
    val results: List<T>
)