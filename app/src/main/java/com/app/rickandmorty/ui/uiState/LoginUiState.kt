package com.app.rickandmorty.ui.uiState

data class LoginUiState(
    val user: String = "",
    val password: String = "",
    val onChangeUser: (String) -> Unit = {},
    val onChagePassword: (String) -> Unit = {},
    val error: Boolean = false,
)
