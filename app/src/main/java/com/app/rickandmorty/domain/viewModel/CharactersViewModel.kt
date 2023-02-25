package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.rickandmorty.domain.CharacterPagSearch
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.domain.repository.SearchCharacterPag
import com.app.rickandmorty.domain.repository.CharacterRepository
import com.app.rickandmorty.models.Character
import kotlinx.coroutines.flow.Flow

class CharactersViewModel(
    private val coroutineContext: CoroutineContext,
    private val searchCharacterPag: SearchCharacterPag,
    private val source: CharacterPagSearch,
    private val repository: CharacterRepository
) : ViewModel() {

    suspend fun searchFavoritesCharacters() : List<Character>? = repository.searchCharactersData()

    suspend fun getPersonagensPorPag(pag: Int) = repository.charactersByPag(pag)

    fun fetchCharacters(): Flow<PagingData<Character>> = getSearchResultStream().cachedIn(viewModelScope)

    private fun getSearchResultStream(): Flow<PagingData<Character>>  = Pager( config = PagingConfig(pageSize = 20, enablePlaceholders = false), pagingSourceFactory = { source }).flow

}