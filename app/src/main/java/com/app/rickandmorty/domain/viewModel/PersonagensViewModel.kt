package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.rickandmorty.domain.PersonagemPagProcura
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.domain.repository.BuscarPersonagemPorPag
import com.app.rickandmorty.domain.repository.PersonagemRepository
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.flow.Flow

class PersonagensViewModel(
    private val coroutineContext: CoroutineContext,
    private val buscarPersonagemPorPag: BuscarPersonagemPorPag,
    private val source: PersonagemPagProcura,
    private val repository: PersonagemRepository
) : ViewModel() {

    suspend fun buscarPersonagensFavoritos() : List<Personagem> = repository.buscarPersonagens()

    suspend fun getPersonagensPorPag(pag: Int) = repository.getPersonagemPorPag(pag)

    fun fetchCharacters(): Flow<PagingData<Personagem>> {
        val newResult: Flow<PagingData<Personagem>> =
            getSearchResultStream().cachedIn(viewModelScope)
        return newResult
    }

    private fun getSearchResultStream(): Flow<PagingData<Personagem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { source }
        ).flow
    }

}