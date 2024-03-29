package com.app.rickandmorty.domain.models

import java.io.Serializable

data class Location (
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
) : Serializable