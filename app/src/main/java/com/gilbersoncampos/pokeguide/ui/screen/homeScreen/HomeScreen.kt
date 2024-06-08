package com.gilbersoncampos.pokeguide.ui.screen.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
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
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navigateToDetails: (Int) -> Unit) {
    val uiState = viewModel.uiState
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        when {
            uiState.isLoading -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }

            uiState.pokedexList.isEmpty() -> Text(text = "lista vazia ")
            else -> PokemonListComponent(
                pokemonList = uiState.pokedexList,
                onClickPokemon = navigateToDetails
            )
        }

    }
}

@Composable
fun PokemonListComponent(pokemonList: List<Pokemon>, onClickPokemon: (Int) -> Unit) {
    LazyColumn {
        items(pokemonList) {
            PokemonItem(it, onClickPokemon)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon, onClick: (Int) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 50.dp)
        .clickable { onClick(pokemon.pokemonEntry) }, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = pokemon.pokemonEntry.toString())
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = pokemon.name)

    }
    HorizontalDivider()
}

@Preview(showBackground = true)
@Composable
fun RenderPreview() {
    val pokemon = Pokemon(pokemonEntry = 1, name = "bulbasaur")

    PokemonItem(pokemon,{})

}