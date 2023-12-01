package com.app.rickandmorty.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.rickandmorty.domain.models.FavoriteCharacter
import com.app.rickandmorty.ui.composables.CardFavorite
import com.app.rickandmorty.ui.uiState.FavoriteUiState

@Composable
fun FavoritesScreen(
    onDeleteCharacter: (Int) -> Unit = {},
    state: FavoriteUiState = FavoriteUiState(),
    onNavigationDetailsFavorite: (Pair<Int, Boolean>) -> Unit = {}
) {
    val favorites = state.favorites
    Box(modifier = Modifier.fillMaxSize()) {
        if (favorites.isNotEmpty()) {
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(favorites) {
                    CardFavorite(
                        character = it,
                        onDetailsCharacter = {
                            onNavigationDetailsFavorite(Pair(it.id, true))
                        }
                    ) {
                        onDeleteCharacter(it.id)
                    }
                }
            }
        } else {
            Text(
                text = "Nenhum personagem!",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp
            )
        }

    }

}