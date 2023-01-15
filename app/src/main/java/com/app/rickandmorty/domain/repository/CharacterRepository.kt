package com.app.rickandmorty.domain.repository

import com.app.rickandmorty.connection.RickApi
import com.app.rickandmorty.data.dao.CharcterDAO
import com.app.rickandmorty.models.Character

class CharacterRepository(
    private val api: RickApi,
    private val acoes: CharcterDAO
) {

    suspend fun charactersByPag(page: Int) = api.searchCharactersByPag(page).results

//    suspend fun getPersonagem(url: String): Personagem? = api.searchCharacter(url).body()

    suspend fun searchCharactersData() : List<Character>? = acoes.searchFavoritesCharacters()

}