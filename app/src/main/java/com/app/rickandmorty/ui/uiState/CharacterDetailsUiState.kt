package com.app.rickandmorty.ui.uiState

import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.domain.models.FavoriteCharacter

sealed class CharacterDetailsUiState {

    object Loading : CharacterDetailsUiState()

    object Failure : CharacterDetailsUiState()

    data class SuccessCharecter(val character: Character, val isSave: Boolean = false) : CharacterDetailsUiState()

    data class SuccessFavorite(val favorite: FavoriteCharacter, val isSave: Boolean = true) : CharacterDetailsUiState()
}