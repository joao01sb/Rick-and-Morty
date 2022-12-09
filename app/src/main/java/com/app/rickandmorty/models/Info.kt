package com.app.rickandmorty.models

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)