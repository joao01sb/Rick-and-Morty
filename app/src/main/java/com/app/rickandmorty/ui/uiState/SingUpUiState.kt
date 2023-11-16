package com.app.rickandmorty.ui.uiState

data class SingUpUiState(
    val name: String = "",
    val user: String = "",
    val password: String = "",
    val onChangeName: (String) -> Unit = {},
    val onChangeUser: (String) -> Unit = {},
    val onChangePassword: (String) -> Unit = {},
)