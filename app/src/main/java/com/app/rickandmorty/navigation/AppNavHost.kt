package com.app.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        loginGraph(
            onNavigateToLogin = { /*TODO*/ },
            onNavigateToSingUp = { /*TODO*/ },
            onNavigateToHome = { }
        )
        homeGraph(
            onNavigationToCaracterDetails = {
                navController.navigateToCharacter(it.id.toString())
            }
        )
        characterDetails(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}