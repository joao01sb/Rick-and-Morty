package com.app.rickandmorty.ui.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.app.rickandmorty.navigation.BottomAppBarItem
import com.app.rickandmorty.navigation.bottomBarItens
import com.app.rickandmorty.ui.theme.black500
import com.app.rickandmorty.ui.theme.green
import com.app.rickandmorty.ui.theme.red

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    itemBottomAppBarItem: BottomAppBarItem = BottomAppBarItem.AllCharacters,
    itensBottomAppBar: List<BottomAppBarItem> = bottomBarItens,
    onChangeBottomAppBar: (BottomAppBarItem) -> Unit = {}
) {
   NavigationBar(
       modifier,
       containerColor = Color.White
   ) {
       itensBottomAppBar.forEach { item ->
            NavigationBarItem(
                label = { Text(text = item.name) },
                selected = itemBottomAppBarItem.name == item.name,
                onClick = { onChangeBottomAppBar(item) },
                icon = { Icon(imageVector = item.icon, contentDescription = null)},
                colors = NavigationBarItemDefaults.colors(indicatorColor = green)
            )
       }
   }
}

@Preview
@Composable
fun AppBottomBarPreview() {
    AppBottomBar()
}