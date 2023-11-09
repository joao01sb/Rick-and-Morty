package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import com.app.rickandmorty.data.dao.CharcterDAO
import com.app.rickandmorty.domain.models.Character

class CharacterViewModel(
    val character: Character,
    val repository: CharcterDAO
) : ViewModel() {

    suspend fun saveCharacter(character: Character) {
        repository.saveCharacter(character)
    }

}