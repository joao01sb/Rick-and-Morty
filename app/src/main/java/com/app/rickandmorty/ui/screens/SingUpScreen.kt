package com.app.rickandmorty.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.rickandmorty.ui.theme.black200
import com.app.rickandmorty.ui.uiState.SingUpUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingUpScreen(
    uiState: SingUpUiState = SingUpUiState(),
    onCreateAccount: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Criar conta",
                style = MaterialTheme.typography.headlineLarge,
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(2f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val focuAtual = LocalFocusManager.current

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                value = uiState.name,
                onValueChange = uiState.onChangeName,
                label = { Text("Nome") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = (KeyboardActions(onNext = { focuAtual.moveFocus(FocusDirection.Next) }))
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },
                value = uiState.name,
                onValueChange = uiState.onChangeUser,
                label = { Text("usuario") },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = (KeyboardActions(onNext = { focuAtual.moveFocus(FocusDirection.Next) }))
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                },
                value = uiState.password,
                onValueChange = uiState.onChangePassword,
                label = {
                    Text(text = "senha")
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = (KeyboardActions(onNext = { focuAtual.moveFocus(FocusDirection.Next) }))
            )

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = onCreateAccount,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = black200),
            ) {
                Text(text = "Salvar", fontSize = 18.sp, modifier = Modifier.padding(2.dp))
            }

        }
    }
}

@Preview
@Composable
fun SingUpScreenPreview() {
    SingUpScreen()
}