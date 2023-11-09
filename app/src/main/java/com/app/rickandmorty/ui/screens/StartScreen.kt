package com.app.rickandmorty.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.rickandmorty.navigation.AppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    onClickCharacter: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {

        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    AppNavHost(navController)
}
