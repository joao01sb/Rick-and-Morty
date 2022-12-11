package com.app.rickandmorty.services

import com.app.rickandmorty.connection.endpt.RickApi
import com.app.rickandmorty.connection.retrofit.RetrofitApp
import com.app.rickandmorty.models.Personagem

object BuscarPersonagens {

    private val rickApiServico: RickApi = RetrofitApp.servico(RickApi::class.java)

    suspend fun buscarUmaPagina(): List<Personagem>  = rickApiServico.buscarPersonagem1("character", 1).results


}