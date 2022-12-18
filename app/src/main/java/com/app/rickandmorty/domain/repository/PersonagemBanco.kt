package com.app.rickandmorty.domain.repository

import androidx.lifecycle.LiveData
import com.app.rickandmorty.data.dao.PersonagemDAO
import com.app.rickandmorty.models.Personagem

class PersonagemBanco(
    private val acoes: PersonagemDAO
) {

    fun salvarPersonagem(personagem: Personagem) {
        acoes.salvarPersonagem(personagem)
    }

    fun buscarPersonagens() : List<Personagem> {
        return acoes.personagensFavoritos()
    }
}