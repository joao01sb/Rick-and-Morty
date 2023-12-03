package com.app.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = DestinationsApp.HomeGraph.rota,
        modifier = modifier
    ) {
        homeGraph(
            onNavigationToCaracterDetails = {
                navController.navigateToCharacter(it.first, it.second)
            }
        )
        characterDetails(
            onBack = {
                navController.navigateUp()
            },
            saveSucess = {
                navController.currentBackStackEntry?.savedStateHandle?.set("save_character", "Adicionado aos favoritos, com sucesso!")
            }
        )
    }
}