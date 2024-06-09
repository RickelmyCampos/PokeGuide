package com.gilbersoncampos.pokeguide.ui.screen.pokemonDetailsScreen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gilbersoncampos.pokeguide.R
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail


@Composable
fun PokemonDetailsScreen(viewModel: PokemonDetailsViewModel = hiltViewModel(), pokemonId: String) {
    val uiState = viewModel.uiState
    LaunchedEffect(pokemonId) {
        viewModel.fechPokemon(pokemonId)
    }
    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
        when {
            uiState.isLoading -> Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }

            else -> {
                uiState.pokemon?.let {
                    PokemonInfos(pokemon=it,isFavorite = uiState.isFavorite,clickFavorite=viewModel::saveFavorites)
                } ?: Text(text = "Não foi possível encontrar o pokemon")
            }
        }
    }
}

@Composable
fun PokemonInfos(pokemon: PokemonDetail,isFavorite:Boolean,clickFavorite:()->Unit) {
    var spriteIsShiny by remember {
        mutableStateOf<Boolean>(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                AsyncImage(
                    model = if (spriteIsShiny) pokemon.spriteShiny else pokemon.spriteDefault,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(200.dp),
                    placeholder = painterResource(id = R.drawable.ic_downloading),
                    error = painterResource(id = R.drawable.ic_image_broken)
                )
                IconButton(onClick = clickFavorite) {
                    Icon( if(isFavorite)Icons.Default.Favorite else Icons.Default.FavoriteBorder, contentDescription = "favoriteIcon")
                }

            }
        }

        Button(onClick = { spriteIsShiny = !spriteIsShiny }) {
            Text(text = "Mostrar " + if (spriteIsShiny) "padrão" else "shiny")
        }

        Text(text = "${pokemon.id} - ${pokemon.name}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Tipo : ${pokemon.type1}${pokemon.type2?.let { ", $it" } ?: ""}")
        Text(text = "Altura : ${pokemon.height}")
        Text(text = "Peso : ${pokemon.weight}")
    }
}

@Composable
@Preview(showBackground = true)
fun PokemonDetailsScreenPreview() {
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

    PokemonInfos(pokemon = pokemon,false,{})
    // PokemonDetailsScreen(pokemonId = "asd")
}