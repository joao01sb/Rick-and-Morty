package com.app.rickandmorty.navigation

sealed class DestinationsApp(val rota: String) {
    object CharacterScreen : DestinationsApp("character")
    object LoginGraph : DestinationsApp("login_graph")
    object AboutScreen : DestinationsApp("about")
    object SplashScreen : DestinationsApp("splashScreen")
    object FavoritesScreen : DestinationsApp("favorites")
    object SingUpScreen : DestinationsApp("singup")
    object Login : DestinationsApp("login")
    object StartScreen : DestinationsApp("start")
    object HomeGraph : DestinationsApp("home_graph")
}

