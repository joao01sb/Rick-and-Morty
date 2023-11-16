package com.app.rickandmorty.domain.models


data class RespList<T>(
    val info: Info,
    val results: List<T>
)