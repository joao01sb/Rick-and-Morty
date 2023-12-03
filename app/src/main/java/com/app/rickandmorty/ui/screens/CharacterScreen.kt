package com.app.rickandmorty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.rickandmorty.R
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.domain.models.FavoriteCharacter
import com.app.rickandmorty.navigation.isFavorite
import com.app.rickandmorty.ui.uiState.CharacterDetailsUiState

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    character: CharacterDetailsUiState? = null,
    onFavorite: () -> Unit = {},
    onBack: () -> Unit = {}
) {
    when (character) {
        is CharacterDetailsUiState.Failure -> {
            Box(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = onBack,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                ) {
                    Text(text = "Voltar")
                }
            }
        }

        is CharacterDetailsUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is CharacterDetailsUiState.SuccessCharecter -> {
            val characterFavorite = character.character

            CharacterDetailsUi(
                onBack = onBack,
                image = characterFavorite.image!!,
                name = characterFavorite.name!!,
                species = characterFavorite.species!!,
                origin = characterFavorite.origin!!.name,
                gender = characterFavorite.gender!!,
                status = characterFavorite.status!!,
                modifier = modifier,
                isFavorite = character.isSave,
                onFavorite = onFavorite
            )
        }

        is CharacterDetailsUiState.SuccessFavorite -> {
            val characterFavorite = character.favorite
            CharacterDetailsUi(
                onBack = onBack,
                image = characterFavorite.image!!,
                name = characterFavorite.name!!,
                species = characterFavorite.species!!,
                origin = characterFavorite.origin.name,
                gender = characterFavorite.gender!!,
                status = characterFavorite.status!!,
                modifier = modifier,
                isFavorite = character.isSave,
                onFavorite = onFavorite
            )
        }

        else -> {}
    }

}

@Composable
private fun CharacterDetailsUi(
    onBack: () -> Unit = {},
    image: String = "",
    name: String = "",
    species: String = "",
    origin: String = "",
    gender: String = "",
    status: String = "",
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onFavorite: () -> Unit = {}
) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.heightIn(50.dp, 56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable {
                        onBack()
                    },
            )
        }
        Box(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(image)
                    .crossfade(true)
                    .build(),
                modifier = modifier
                    .fillMaxSize(),
                placeholder = painterResource(id = R.drawable.rick),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.padding(bottom = 6.dp))
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Nome: $name",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Local: $origin",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Especie: $species",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Genero: $gender",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Status: $status",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        if (!isFavorite) {
            Button(
                onClick = onFavorite,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Text(text = "Salvar", fontSize = 18.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.padding(bottom = 14.dp))
        }
    }
}

@Preview
@Composable
fun CharacterDetailsUiPreview() {
    CharacterDetailsUi()
}

@Preview
@Composable
fun CharacterScreenPreview() {
    CharacterScreen()
}