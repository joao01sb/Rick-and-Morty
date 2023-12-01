package com.app.rickandmorty.navigation

sealed class DestinationsApp(val rota: String) {
    object CharacterScreen : DestinationsApp("character")
    object SplashScreen : DestinationsApp("splashScreen")
    object FavoritesScreen : DestinationsApp("favorites")
    object StartScreen : DestinationsApp("start")
    object HomeGraph : DestinationsApp("home_graph")
}