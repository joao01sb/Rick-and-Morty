package com.app.rickandmorty.domain.repository

import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.models.Character
import kotlinx.coroutines.withContext

class SearchCharacterPag(
    private val coroutineContext: CoroutineContext,
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(page: Int): List<Character> = withContext(coroutineContext.IO) {
        repository.charactersByPag(page)
    }
}