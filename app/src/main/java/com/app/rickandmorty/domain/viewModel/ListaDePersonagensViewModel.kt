package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.rickandmorty.domain.CharacterPagingSource
import com.app.rickandmorty.domain.CoroutineContext
import com.app.rickandmorty.domain.repository.GetPersonagemByPag
import com.app.rickandmorty.domain.repository.PersonagensRepository1
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.flow.Flow

class ListaDePersonagensViewModel(
    private val coroutineContext: CoroutineContext,
    private val getPersonagemByPag: GetPersonagemByPag,
    private val source: CharacterPagingSource
) : ViewModel() {

//    suspend fun buscarPersonagens(pag: Int) : LiveData<List<Personagem>> {
//        return repository.buscarPagina(pag)
//    }
//
//    suspend fun buscarPersonagem(nome: String) : Personagem? {
//        return repository.buscarPersonagem(nome)
//    }

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