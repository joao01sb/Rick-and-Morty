package com.app.rickandmorty.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class RespList<T>(
    val info: Info,
    val results: List<T>
)