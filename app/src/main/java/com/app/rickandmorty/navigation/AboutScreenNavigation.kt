package com.app.rickandmorty.navigation

import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.app.rickandmorty.ui.screens.DetailsScreen
import com.app.rickandmorty.ui.screens.FavoritesScreen
import com.app.rickandmorty.ui.viewModel.FavoritesScreenViewModel
import org.koin.androidx.compose.koinViewModel

internal const val aboutScreenRoute = "about"
fun NavGraphBuilder.aboutScreenNavigation(

) {
    composable(route = aboutScreenRoute) {
        val scope = rememberCoroutineScope()
        DetailsScreen()
    }
}

fun NavController.navigateToAbout(
    navOptions: NavOptions? = null
) {
    navigate(aboutScreenRoute, navOptions)
}