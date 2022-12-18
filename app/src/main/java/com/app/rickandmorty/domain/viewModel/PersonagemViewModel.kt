package com.app.rickandmorty.domain.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.rickandmorty.domain.repository.PersonagemBanco
import com.app.rickandmorty.domain.repository.PersonagemRepository
import com.app.rickandmorty.models.Personagem

class PersonagemViewModel(
    val personagem: Personagem

) : ViewModel() {



}