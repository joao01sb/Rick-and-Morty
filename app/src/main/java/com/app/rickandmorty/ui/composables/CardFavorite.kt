package com.app.rickandmorty.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.app.rickandmorty.R
import com.app.rickandmorty.domain.models.Character
import com.app.rickandmorty.domain.models.FavoriteCharacter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CardFavorite(
    modifier: Modifier = Modifier,
    character: FavoriteCharacter? = null,
    onDetailsCharacter: (FavoriteCharacter) -> Unit = {},
    onDeleteFavorite: () -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .combinedClickable(
                onClick = {
                    onDetailsCharacter(character!!)
                },
                onLongClick = {
                    onDeleteFavorite()
                },
            )
            .padding(4.dp)
    ) {
        val localContext = LocalContext.current
        Box {
            AsyncImage(
                modifier = Modifier.size(140.dp),
                model = ImageRequest.Builder(localContext)
                    .data(character?.image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(R.drawable.rick)
            )
        }
        Spacer(modifier = Modifier.padding(top = 2.dp))
        Text(
            text = character?.name ?: " Undefined",
            fontSize = 13.sp,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(top = 2.dp))
        Text(
            text = character?.origin ?: " Undefined",
            fontSize = 10.sp,
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun CardFavoritePreview() {
    CardFavorite()
}