package com.app.rickandmorty.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.app.rickandmorty.ui.screens.FavoritesScreen
import com.app.rickandmorty.ui.viewModel.FavoritesScreenViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

internal const val favoritesScreenRoute = "favorites"
fun NavGraphBuilder.favoritesScreenNavigation() {
    composable(route = favoritesScreenRoute) {
        val viewmodel = koinViewModel<FavoritesScreenViewModel>()
        val uiState by viewmodel.uiState.collectAsState()
        val scope = rememberCoroutineScope()
        FavoritesScreen(
            state = uiState,
            onDeleteCharacter = { characterId ->
                scope.launch {
                    viewmodel.delete(characterId)
                }
            },
            onSharedCharacter = {}
        )
    }
}

fun NavController.navigateToFavorites(
    navOptions: NavOptions? = null
) {
    navigate(favoritesScreenRoute, navOptions)
}