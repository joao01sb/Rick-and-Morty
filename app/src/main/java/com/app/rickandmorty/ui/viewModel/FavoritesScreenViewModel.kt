package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.rickandmorty.data.local.AppDataBase
import com.app.rickandmorty.data.local.entitys.toFavoriteCharacter
import com.app.rickandmorty.data.local.mappers.toCharacter
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.domain.models.FavoriteCharacter
import com.app.rickandmorty.ui.uiState.CharacterDetailsUiState
import com.app.rickandmorty.ui.uiState.FavoriteUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesScreenViewModel(
    private val dataBase: AppDataBase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<FavoriteUiState>(FavoriteUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            dataBase.favoriteDAO().allFavorites().collect { favorites ->
                _uiState.update {
                    it.copy(
                        favorites = favorites.map { it.toFavoriteCharacter() }
                    )
                }
            }
        }
    }

    suspend fun delete(id: Int) {
        dataBase.favoriteDAO().delete(id)
    }
}

