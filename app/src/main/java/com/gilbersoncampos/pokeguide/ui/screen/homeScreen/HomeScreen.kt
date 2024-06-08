package com.gilbersoncampos.pokeguide.ui.screen.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel= hiltViewModel()){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home Screen")
        Button(onClick = { viewModel.fechPokedex() }) {
            Text(text = "Chamar")
        }
    }
}