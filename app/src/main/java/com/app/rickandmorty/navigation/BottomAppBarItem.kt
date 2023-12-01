package com.app.rickandmorty.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomAppBarItem(
    val name: String,
    val icon: ImageVector
) {
    object AllCharacters : BottomAppBarItem(
        name = "start",
        icon = Icons.Filled.Home
    )
    object Favorites : BottomAppBarItem(
        name = "favorites",
        icon = Icons.Filled.Favorite
    )
}

val bottomBarItens = listOf(
    BottomAppBarItem.AllCharacters,
    BottomAppBarItem.Favorites
)
