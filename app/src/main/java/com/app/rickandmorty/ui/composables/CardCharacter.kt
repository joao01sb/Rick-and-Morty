package com.app.rickandmorty.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.app.rickandmorty.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCharacter(
    modifier: Modifier = Modifier,
    image: String,
    state: String,
    name: String
) {
    val localContext = LocalContext.current

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(border = BorderStroke(1.dp, color = Color.Black))
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.size(200.dp),
                model = ImageRequest.Builder(localContext)
                    .data("https://rickandmortyapi.com/api/character/avatar/1.jpeg")
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(R.drawable.rick),
                onLoading = {

                },
                onError = {

                }
            )
        }
        Spacer(modifier = Modifier.padding(top = 2.dp))
        Text(text = name, fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview
@Composable
fun CardCharacterPreview() {
    CardCharacter(image = "", state = "Alive", name = "Rick Sanchez")
}