package com.gilbersoncampos.pokeguide.ui.screen.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.ui.theme.PokeGuideTheme

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val uiState = viewModel.uiState
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Home Screen")
        when {
            uiState.isLoading -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }

            uiState.pokedexList.isEmpty() -> Text(text = "lista vazia ")
            else -> PokemonListComponent(uiState.pokedexList)
        }

    }
}

@Composable
fun PokemonListComponent(pokemonList: List<Pokemon>) {
    LazyColumn {
        items(pokemonList) {
            PokemonItem(it)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = pokemon.pokemonEntry.toString())
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = pokemon.name)
    }
}

@Preview(showBackground = true)
@Composable
fun RenderPreview() {
    PokeGuideTheme {
        val pokemon = Pokemon(pokemonEntry = 1, name = "bulbasaur")
        PokemonItem(pokemon)
    }
}