package com.app.rickandmorty.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.rickandmorty.connection.RickApi
import com.app.rickandmorty.models.Personagem

class PersonagensRepository1(
    private val apiRick: RickApi
) {

    suspend fun buscarPagina(pag: Int): LiveData<List<Personagem>> {
        val personagens = MutableLiveData<List<Personagem>>()
        try {
            val listaDePersonagens = apiRick.buscarPersonagem1(pag).results
            personagens.value = listaDePersonagens
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return personagens
    }

    suspend fun buscarPersonagem(personagem: String) : Personagem? {
        var personagemResp: Personagem? = null
        try {
            val personagem = apiRick.buscarPersonagem(personagem)
            personagemResp = if (personagem.isSuccessful)
                personagem.body()
            else
                null
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return personagemResp
    }
}