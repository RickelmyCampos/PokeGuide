package com.gilbersoncampos.pokeguide.ui.screen.pokemonDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PokemonDetailsScreen(pokemonId:String){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text ="teste: $pokemonId")
    }
}
@Composable
@Preview(showBackground = true)
fun PokemonDetailsScreenPreview(){
    PokemonDetailsScreen("asd")
}