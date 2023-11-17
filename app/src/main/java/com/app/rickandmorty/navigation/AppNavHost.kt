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
        startDestination = DestinationsApp.SplashScreen.rota,
        modifier = modifier
    ) {
        loginGraph(
            onNavigateToLogin = { /*TODO*/ },
            onNavigateToSingUp = { /*TODO*/ },
            onNavigateToHome = { }
        )

    }
}