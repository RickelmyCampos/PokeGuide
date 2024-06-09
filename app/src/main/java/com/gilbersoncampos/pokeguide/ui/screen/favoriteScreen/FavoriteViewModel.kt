package com.gilbersoncampos.pokeguide.ui.screen.favoriteScreen

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail
import com.gilbersoncampos.pokeguide.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {
    private var _uiState = MutableFavoriteUiState()
    val uiState: FavoriteUiState = _uiState

    init {
        fetchFavorites()
    }

    fun fetchFavorites() {
        viewModelScope.launch {
            pokemonRepository.getAllFavorites().collect{
                _uiState.favoriteList =it
            }
        }
    }

    fun removeFavorite(pokemon: PokemonDetail) {
        viewModelScope.launch {
            pokemonRepository.removeFavoritePokemon(pokemon)
        }
    }
}

class MutableFavoriteUiState : FavoriteUiState {
    override var favoriteList: List<PokemonDetail> by mutableStateOf(emptyList())
    override var isLoading: Boolean by mutableStateOf(false)
}

@Stable
interface FavoriteUiState {
    val favoriteList: List<PokemonDetail>
    val isLoading: Boolean
}