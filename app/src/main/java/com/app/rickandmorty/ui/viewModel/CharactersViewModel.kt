package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.app.rickandmorty.data.local.entitys.CharacterEntity
import com.app.rickandmorty.data.local.mappers.toCharacter
import kotlinx.coroutines.flow.map

class CharactersViewModel(
    pager: Pager<Int, CharacterEntity>
) : ViewModel() {

    val characterPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toCharacter() }
        }
        .cachedIn(viewModelScope)

}