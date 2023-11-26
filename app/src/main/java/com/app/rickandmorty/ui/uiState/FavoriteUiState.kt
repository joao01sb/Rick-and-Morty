package com.app.rickandmorty.ui.uiState

import com.app.rickandmorty.domain.models.FavoriteCharacter

data class FavoriteUiState(
    val favorites: List<FavoriteCharacter> = emptyList()
)