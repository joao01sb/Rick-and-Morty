package com.app.rickandmorty.models

@kotlinx.serialization.Serializable
data class Usuario(
    val id: String,
    val user: String,
    val nome: String,
    val senha: String
)