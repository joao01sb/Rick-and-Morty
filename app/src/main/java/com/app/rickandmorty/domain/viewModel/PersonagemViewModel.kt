package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.ViewModel
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.models.Personagem

class PersonagemViewModel(
    val personagem: Personagem,
    val repository: PersonagemDAO
) : ViewModel() {

    suspend fun salvarPersonagem(personagem: Personagem) {
        repository.salvarPersonagem(personagem)
    }

}