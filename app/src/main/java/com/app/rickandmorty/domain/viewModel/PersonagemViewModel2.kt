package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.ViewModel
import com.app.rickandmorty.domain.repository.PersonagemBanco
import com.app.rickandmorty.models.Personagem

class PersonagemViewModel2(
    private val repository: PersonagemBanco
) : ViewModel() {

    fun salvar(personagem: Personagem) {
        repository?.salvarPersonagem(personagem)
    }

    fun buscarPersonagensSalvos() : List<Personagem>? {
        return repository?.buscarPersonagens()
    }
}