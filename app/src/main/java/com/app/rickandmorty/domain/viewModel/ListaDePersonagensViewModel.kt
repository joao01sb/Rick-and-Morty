package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.rickandmorty.domain.repository.PersonagensRepository
import com.app.rickandmorty.models.Personagem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ListaDePersonagensViewModel(
    private val repository: PersonagensRepository
) : ViewModel() {

    suspend fun buscarPersonagens(pag: Int) : LiveData<List<Personagem>> {
        return repository.buscarPagina(pag)
    }

    suspend fun buscarPersonagem(nome: String) : Personagem? {
        return repository.buscarPersonagem(nome)
    }

}