package com.gilbersoncampos.pokeguide.ui.screen.favoriteScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteScreen(){
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        Text(text = "Favorite Screen")
    }
}