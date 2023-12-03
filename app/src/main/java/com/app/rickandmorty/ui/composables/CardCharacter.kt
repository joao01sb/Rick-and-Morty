package com.app.rickandmorty.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.app.rickandmorty.R
import com.app.rickandmorty.ui.theme.black200

@Composable
fun CardCharacter(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    onDetailsCharacter: () -> Unit = {}
) {
    val localContext = LocalContext.current
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(6.dp)
            .border(border = BorderStroke(0.1.dp, color = Color.Black))
            .clickable { onDetailsCharacter() }.background(color = Color.White)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.size(200.dp),
                model = ImageRequest.Builder(localContext)
                    .data(image)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                placeholder = painterResource(R.drawable.rick)
            )
        }
        Spacer(modifier = Modifier.padding(top = 2.dp))
        Text(text = name, fontSize = 18.sp, maxLines = 1, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(top = 2.dp))
    }
}

@Preview
@Composable
fun CardCharacterPreview() {
    CardCharacter(image = "", name = "Rick Sanchez")
}