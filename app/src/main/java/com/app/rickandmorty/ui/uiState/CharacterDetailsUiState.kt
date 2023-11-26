package com.app.rickandmorty.ui.uiState

import com.app.rickandmorty.domain.models.Character

sealed class CharacterDetailsUiState {

    object Loading : CharacterDetailsUiState()

    object Failure : CharacterDetailsUiState()

    class Success(val character: Character) : CharacterDetailsUiState()

}