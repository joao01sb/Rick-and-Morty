package com.app.rickandmorty.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navOptions
import androidx.navigation.navigation
import com.app.rickandmorty.domain.models.Character

fun NavGraphBuilder.homeGraph(
    onNavigationToCaracterDetails: (Pair<Int, Boolean>) -> Unit
) {
    navigation(
        startDestination = DestinationsApp.StartScreen.rota,
        route = DestinationsApp.HomeGraph.rota
    ) {
        startScreenNavigation(onClickCharacter = onNavigationToCaracterDetails)
        favoritesScreenNavigation(
            onNavigationDetailsFavorite = onNavigationToCaracterDetails
        )
    }
}

fun NavController.navigateSingleTopWithPopUpTo(
    item: BottomAppBarItem
) {
    val (route, navigate) = when (item) {
        BottomAppBarItem.Favorites -> Pair(
            DestinationsApp.FavoritesScreen.rota,
            ::navigateToFavorites
        )
        BottomAppBarItem.AllCharacters -> Pair(
            DestinationsApp.StartScreen.rota,
            ::navigateToStart
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}