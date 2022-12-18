package com.app.rickandmorty.data

import com.app.rickandmorty.connection.RickApi
import com.app.rickandmorty.domain.repository.GetPersonagemByPag
import com.app.rickandmorty.domain.repository.PersonagemRepository
import com.app.rickandmorty.models.Personagem

class PersonagemRepositoryImpl(private val api: RickApi): PersonagemRepository {

    override suspend fun getCharactersByPage(page: Int) = api.buscarPersonagem1(page).results

    override suspend fun getCharacter(url: String): Personagem? = api.buscarPersonagem(url).body()

}