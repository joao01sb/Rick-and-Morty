package com.app.rickandmorty.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.app.rickandmorty.navigation.AppNavHost
import com.app.rickandmorty.navigation.BottomAppBarItem
import com.app.rickandmorty.navigation.bottomBarItens
import com.app.rickandmorty.ui.composables.AppBottomBar
import com.app.rickandmorty.ui.composables.CardCharacter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onClickCharacter: () -> Unit = {}
) {

    Column(modifier= modifier) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(
                mutableListOf<String>(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                )
            ) {
                CardCharacter(
                    modifier = Modifier.padding(1.dp),
                    image = "",
                    state = "Alive",
                    name = "Rick Sanchez"
                )
            }
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    StartScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    bottomAppBarItemSelected: BottomAppBarItem = bottomBarItens.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    isShowBottomBar: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (isShowBottomBar) {
                AppBottomBar(
                    itemBottomAppBarItem = bottomAppBarItemSelected,
                    onChangeBottomAppBar = onBottomAppBarItemSelectedChange,
                    itensBottomAppBar = bottomBarItens
                )
            }
        }
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }

}
