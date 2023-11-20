package com.app.rickandmorty.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.ui.screens.DetailsScreen
import com.app.rickandmorty.ui.screens.FavoritesScreen
import com.app.rickandmorty.ui.screens.StartScreen
import com.app.rickandmorty.ui.viewModel.CharactersViewModel
import com.app.rickandmorty.ui.viewModel.FavoritesScreenViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeGraph(
    onNavigationToStart: () -> Unit,
    onNavigationToFavorites: () -> Unit,
    onNavigationToAbout: () -> Unit,
    onNavigationToCaracterDetails: (Character) -> Unit
) {
    navigation(
        startDestination = DestinationsApp.StartScreen.rota,
        route = DestinationsApp.HomeGraph.rota
    ) {

        composable(route = DestinationsApp.StartScreen.rota) {
            val viewmodel = koinViewModel<CharactersViewModel>()
            val charactersPaging = viewmodel.characterPagingFlow.collectAsLazyPagingItems()
            StartScreen(
                charactersPage = charactersPaging,
                onClickCharacter = onNavigationToCaracterDetails
            )
        }
        composable(route = DestinationsApp.FavoritesScreen.rota) {
            val viewmodel = koinViewModel<FavoritesScreenViewModel>()
            FavoritesScreen()
        }
        composable(route = DestinationsApp.AboutScreen.rota) {
            DetailsScreen()
        }
    }
}