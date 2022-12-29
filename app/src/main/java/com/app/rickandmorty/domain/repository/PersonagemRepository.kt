package com.app.rickandmorty.domain.repository

import com.app.rickandmorty.connection.RickApi
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.models.Personagem

class PersonagemRepository(
    private val api: RickApi,
    private val acoes: PersonagemDAO
) {

    suspend fun getPersonagemPorPag(page: Int) = api.buscarPersonagem1(page).results

    suspend fun getPersonagem(url: String): Personagem? = api.buscarPersonagem(url).body()

    suspend fun buscarPersonagens() : List<Personagem> = acoes.personagensFavoritos()

}