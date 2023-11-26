package com.app.rickandmorty.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.rickandmorty.navigation.AppNavHost
import com.app.rickandmorty.navigation.BottomAppBarItem
import com.app.rickandmorty.navigation.bottomBarItens
import com.app.rickandmorty.navigation.navigateSingleTopWithPopUpTo
import com.app.rickandmorty.ui.composables.AppBottomBar
import com.app.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    RickApp(navController)
                }
            }
        }
    }
}

@Composable
fun RickApp(navController: NavHostController = rememberNavController()) {

    val backStackEntryState by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntryState?.destination
    val currentRoute = currentDestination?.route

    val selectedItem by remember(currentDestination) {
        val item = when (currentRoute) {
            "favorites" -> BottomAppBarItem.Favorites
            "about" -> BottomAppBarItem.About
            else -> BottomAppBarItem.AllCharacters
        }
        mutableStateOf(item)
    }

    val containsInBottomAppBarItems = when (currentRoute) {
        "start", "favorites", "about" -> true
        else -> false
    }

    App(
        bottomAppBarItemSelected = selectedItem,
        onBottomAppBarItemSelectedChange = { item -> navController.navigateSingleTopWithPopUpTo(item) },
        isShowBottomBar = containsInBottomAppBarItems
    ) {
        AppNavHost(navController = navController)
    }
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

@Preview
@Composable
fun AppPreview() {
    App(
        isShowBottomBar = true
    ) {
        AppNavHost(navController = rememberNavController())
    }
}