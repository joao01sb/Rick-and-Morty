package com.app.rickandmorty.domain.models

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)