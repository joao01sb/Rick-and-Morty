package com.app.rickandmorty.domain.repository

import com.app.rickandmorty.models.Personagem

interface PersonagemRepository {
    suspend fun getCharactersByPage(page: Int) : List<Personagem>
    suspend fun getCharacter(url: String) : Personagem?
}