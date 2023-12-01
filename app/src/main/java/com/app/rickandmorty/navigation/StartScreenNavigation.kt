package com.app.rickandmorty.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.ui.screens.StartScreen
import com.app.rickandmorty.ui.viewModel.CharactersViewModel
import org.koin.androidx.compose.koinViewModel

internal const val startScreenRoute = "start"
fun NavGraphBuilder.startScreenNavigation(
    onClickCharacter: (Pair<Int, Boolean>) -> Unit = {}
) {
    composable(route = startScreenRoute) {
        val viewmodel = koinViewModel<CharactersViewModel>()
        val charactersPaging = viewmodel.characterPagingFlow.collectAsLazyPagingItems()
        StartScreen(
            charactersPage = charactersPaging,
            onClickCharacter = onClickCharacter
        )
    }
}

fun NavController.navigateToStart(
    navOptions: NavOptions? = null
) {
    navigate(startScreenRoute, navOptions)
}