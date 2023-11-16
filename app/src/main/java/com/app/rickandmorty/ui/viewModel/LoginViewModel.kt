package com.app.rickandmorty.ui.viewModel

import androidx.lifecycle.ViewModel
import com.app.rickandmorty.ui.uiState.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _state: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state.asStateFlow()

    init {
        _state.update { state ->
            state.copy(
                onChangeUser = {
                    _state.value = state.copy(
                        user = it
                    )
                },
                onChagePassword = {
                    _state.value = state.copy(
                        password = it
                    )
                }
            )
        }
    }

}