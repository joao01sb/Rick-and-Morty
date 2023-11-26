package com.app.rickandmorty.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.rickandmorty.ui.screens.CharacterScreen
import com.app.rickandmorty.ui.viewModel.CharacterDetailsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


internal const val characterDetailsRoute = "characterDetails"
internal const val characterId = "characterId"
fun NavGraphBuilder.characterDetails(
    onBack: () -> Unit
) {
    composable(
        route = "$characterDetailsRoute/{$characterId}"
    ) {navBackStackEntry ->
        navBackStackEntry.arguments?.getString(characterId)?.let { id ->
            val viewModel = koinViewModel<CharacterDetailsViewModel>()
            LaunchedEffect(key1 = Unit) {
                viewModel.findCharacterById(id)
            }
            val character by viewModel.uiState.collectAsState()
            val scope = rememberCoroutineScope()
            CharacterScreen(
                character = character,
                onFavorite = {
                    scope.launch {
                        viewModel.saveCharacter()
                    }
                },
                onBack = {
                    onBack()
                }
            )
        } ?: LaunchedEffect(Unit) {
            onBack()
        }
    }
}

fun NavController.navigateToCharacter(id: String){
    navigate("$characterDetailsRoute/$id")
}
