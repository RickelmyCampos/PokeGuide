package com.gilbersoncampos.pokeguide.ui.screen.favoriteScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gilbersoncampos.pokeguide.R
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail
import com.gilbersoncampos.pokeguide.ui.screen.homeScreen.PokemonListComponent

@Composable
fun FavoriteScreen(viewModel: FavoriteViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        when {
            uiState.isLoading -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }

            uiState.favoriteList.isEmpty() -> Text(text = stringResource(R.string.empty_text_favorite_list))
            else -> FavoritesListPokemon(
                pokemonList = uiState.favoriteList,
                onRemove = viewModel::removeFavorite
            )
        }

    }
}

@Composable
fun FavoritesListPokemon(pokemonList: List<PokemonDetail>, onRemove: (PokemonDetail) -> Unit) {
    LazyColumn {
        items(pokemonList) {
            PokemonCard(it, onRemove = onRemove)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun PokemonCard(pokemon: PokemonDetail, onRemove: (PokemonDetail) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = pokemon.spriteDefault,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.size(100.dp),
                placeholder = painterResource(id = R.drawable.ic_downloading),
                error = painterResource(id = R.drawable.ic_image_broken)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {

                Text(text = "${pokemon.id} - ${pokemon.name}")
                Text(text = "Tipo : ${pokemon.type1}${pokemon.type2?.let { ", $it" } ?: ""}")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onRemove(pokemon) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "remove favorite")
            }
        }
    }
}

@Composable
@Preview
fun PokemonCardPreview() {
    val pokemon = PokemonDetail(
        id = 1,
        type2 = "POISON",
        type1 = "Eletric",
        spriteShiny = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        spriteDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        isDefault = true,
        weight = 21,
        order = 21,
        baseExperience = 12,
        name = "bubasaur",
        height = 12
    )
    PokemonCard(pokemon,{})
}