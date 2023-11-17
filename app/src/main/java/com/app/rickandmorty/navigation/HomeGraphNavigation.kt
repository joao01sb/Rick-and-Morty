package com.app.rickandmorty.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeGraph(
    onNavigationToStart: () -> Unit,
    onNavigationToFavorites: () -> Unit,
    onNavigationToAbout: () -> Unit,
    onNavigationToCaracterDetails: () -> Unit
) {
    navigation(
        startDestination = DestinationsApp.StartScreen.rota,
        route = DestinationsApp.HomeGraph.rota
    ) {

        composable(route = DestinationsApp.StartScreen.rota) {

        }
        composable(route = DestinationsApp.FavoritesScreen.rota) {

        }
        composable(route = DestinationsApp.AboutScreen.rota) {

        }

    }
}