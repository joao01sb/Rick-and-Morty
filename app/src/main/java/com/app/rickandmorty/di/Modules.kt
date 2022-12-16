package com.app.rickandmorty.di

import com.app.rickandmorty.domain.repository.PersonagensRepository
import com.app.rickandmorty.domain.viewModel.ListaDePersonagensViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appDados = module {

    single<PersonagensRepository> {
        PersonagensRepository(get())
    }

    viewModel { ListaDePersonagensViewModel(get()) }
}