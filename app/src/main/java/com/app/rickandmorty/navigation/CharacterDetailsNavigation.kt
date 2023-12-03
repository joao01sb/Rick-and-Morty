package com.app.rickandmorty.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.app.rickandmorty.ui.screens.CharacterScreen
import com.app.rickandmorty.ui.viewModel.CharacterDetailsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel


internal const val characterDetailsRoute = "characterDetails"
internal const val characterId = "characterId"
internal const val isFavorite = "isFavorite"
fun NavGraphBuilder.characterDetails(
    onBack: () -> Unit,
    saveSucess: () -> Unit = {}
) {
    composable(
        route = "$characterDetailsRoute/{characterId}/{isFavorite}",
        arguments = listOf(
            navArgument("characterId") { type = NavType.IntType },
            navArgument("isFavorite") { type = NavType.BoolType }
        )
    ) {navBackStackEntry ->
        navBackStackEntry.arguments?.getInt(characterId)?.let { id ->
            val isFavorite = navBackStackEntry.arguments?.getBoolean(isFavorite)
            val viewModel = koinViewModel<CharacterDetailsViewModel>()
            LaunchedEffect(key1 = Unit) {
                if (isFavorite != null) {
                    viewModel.findCharacterById(id, isFavorite)
                }
            }
            val character by viewModel.uiState.collectAsState()
            val scope = rememberCoroutineScope()
            CharacterScreen(
                character = character,
                onFavorite = {
                    try {
                        scope.launch {
                            viewModel.saveCharacter()
                        }
                        saveSucess()
                    } catch (e: Exception) {
                        e.printStackTrace()
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

fun NavController.navigateToCharacter(id: Int, isFavorite: Boolean){
    val route = "$characterDetailsRoute/$id/$isFavorite"
    navigate(route)
}
