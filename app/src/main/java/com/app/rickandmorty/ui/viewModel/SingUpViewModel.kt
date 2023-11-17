package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import com.app.rickandmorty.ui.uiState.SingUpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SingUpViewModel : ViewModel() {

    private val _state: MutableStateFlow<SingUpUiState> = MutableStateFlow(SingUpUiState())
    val state: StateFlow<SingUpUiState>
        get() = _state.asStateFlow()

    init {
        _state.update { state ->
            state.copy(
                onChangeName = {
                    _state.value = state.copy(
                        name = it
                    )
                },
                onChangeUser = {
                    _state.value = state.copy(
                        user = it
                    )
                },
                onChangePassword = {
                    _state.value = state.copy(
                        password = it
                    )
                }
            )
        }
    }
}