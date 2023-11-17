package com.app.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


internal const val characterDetailsRoute = "characterDetails"
fun NavGraphBuilder.characterDetails(
    onSaveCharacter: () -> Unit,
    onBack: () -> Unit
) {
    composable(
        route = characterDetailsRoute
    ) {

    }
}