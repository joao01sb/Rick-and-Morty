package com.app.rickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.rickandmorty.ui.screens.LoginScreen
import com.app.rickandmorty.ui.screens.SingUpScreen
import com.app.rickandmorty.ui.viewModel.LoginViewModel
import com.app.rickandmorty.ui.viewModel.SingUpViewModel
import org.koin.androidx.compose.koinViewModel


fun NavGraphBuilder.loginGraph(
    onNavigateToLogin: () -> Unit,
    onNavigateToSingUp: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    navigation(
        startDestination = DestinationsApp.Login.rota,
        route = DestinationsApp.LoginGraph.rota
    ) {
        composable(
            route = DestinationsApp.Login.rota
        ) {
            val viewModel = koinViewModel<LoginViewModel>()
            val state by viewModel.state.collectAsState()

            LoginScreen(
                uiState = state,
                onSingIn = onNavigateToHome,
                onSingUp = onNavigateToSingUp
            )
        }

        composable(
            route = DestinationsApp.SingUpScreen.rota
        ) {
            val viewModel = koinViewModel<SingUpViewModel>()
            val state by viewModel.state.collectAsState()

            SingUpScreen(
                uiState = state,
                onCreateAccount = onNavigateToLogin
            )
        }
    }
}