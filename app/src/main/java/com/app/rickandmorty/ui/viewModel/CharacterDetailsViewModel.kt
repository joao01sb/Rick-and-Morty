package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.rickandmorty.data.local.AppDataBase
import com.app.rickandmorty.data.local.entitys.toFavoriteCharacter
import com.app.rickandmorty.domain.models.toEntity
import com.app.rickandmorty.domain.models.toFavoriteEntity
import com.app.rickandmorty.ui.uiState.CharacterDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(
    private val dataBase: AppDataBase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharacterDetailsUiState>(
        CharacterDetailsUiState.Loading
    )
    val uiState = _uiState.asStateFlow()



    suspend fun saveCharacter() {
        when (_uiState.value) {
            is CharacterDetailsUiState.SuccessCharecter -> {
                dataBase.favoriteDAO().saveCharacter((_uiState.value as CharacterDetailsUiState.SuccessCharecter).character.toFavoriteEntity())
            }
            else -> {}
        }
    }

    fun findCharacterById(id: Int, isFavorite: Boolean) {
        _uiState.update {
            CharacterDetailsUiState.Loading
        }
        viewModelScope.launch {
            if (isFavorite) {
                val state = dataBase.favoriteDAO().findFavoriteById(id)?.let {
                    CharacterDetailsUiState.SuccessFavorite(it)
                } ?: CharacterDetailsUiState.Failure
                _uiState.update {
                    state
                }
            } else {
                val state = dataBase.characterDAO().findCharacterById(id)?.let {
                    CharacterDetailsUiState.SuccessCharecter(it)
                } ?: CharacterDetailsUiState.Failure
                _uiState.update {
                    state
                }
            }
        }
    }



}