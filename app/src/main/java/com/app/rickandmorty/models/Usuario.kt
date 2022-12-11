package com.app.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Usuario(
    @PrimaryKey
    val id: String,
    val user: String,
    val nome: String,
    val senha: String
)