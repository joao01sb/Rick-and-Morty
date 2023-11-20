package com.app.rickandmorty.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.ui.composables.CardCharacter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    charactersPage: LazyPagingItems<Character>,
    onClickCharacter: (Character) -> Unit = {}
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = charactersPage.loadState) {
        if (charactersPage.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (charactersPage.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        if (charactersPage.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Column(modifier = modifier) {
                LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                    items(charactersPage.itemCount) {
                        charactersPage[it]?.let { character ->
                            CardCharacter(
                                image = character.image!!,
                                name = character.name!!
                            ) {
                                onClickCharacter(character)
                            }
                        }
                    }
                    item {
                        if (charactersPage.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun StartScreenPreview() {
//    StartScreen()
}

