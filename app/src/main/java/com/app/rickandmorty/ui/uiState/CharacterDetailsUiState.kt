package com.app.rickandmorty.ui.uiState

import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.domain.models.FavoriteCharacter

sealed class CharacterDetailsUiState {

    object Loading : CharacterDetailsUiState()

    object Failure : CharacterDetailsUiState()

    class SuccessCharecter(val character: Character) : CharacterDetailsUiState()

    class SuccessFavorite(val favorite: FavoriteCharacter) : CharacterDetailsUiState()
}