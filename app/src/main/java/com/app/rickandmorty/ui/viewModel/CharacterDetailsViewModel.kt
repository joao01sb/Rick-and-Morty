package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.rickandmorty.data.local.AppDataBase
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
            is CharacterDetailsUiState.Success -> {
                dataBase.favoriteDAO().saveCharacter((_uiState.value as CharacterDetailsUiState.Success).character.toFavoriteEntity())
            }
            else -> {}
        }
    }

    fun findCharacterById(id: String) {
        _uiState.update {
            CharacterDetailsUiState.Loading
        }
        viewModelScope.launch {
            val state = dataBase.characterDAO().findCharacterById(id)?.let {
                CharacterDetailsUiState.Success(it)
            } ?: CharacterDetailsUiState.Failure
            _uiState.update {
                state
            }
        }
    }



}