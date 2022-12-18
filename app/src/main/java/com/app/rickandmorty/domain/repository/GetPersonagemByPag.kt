package com.app.rickandmorty.domain.repository

import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPersonagemByPag(
    private val coroutineContext: CoroutineContext,
    private val repository: PersonagemRepository
) {
    suspend operator fun invoke(page: Int): List<Personagem> = withContext(coroutineContext.IO) {
        repository.getCharactersByPage(page)
    }
}