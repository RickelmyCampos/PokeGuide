package com.gilbersoncampos.pokeguide.ui.screen.pokemonDetailsScreen

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail
import com.gilbersoncampos.pokeguide.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {
    private var _uiState = MutablePokemonDetailsUiState()
    val uiState: PokemonDetailsUiState = _uiState
    fun fechPokemon(id: String) {
        viewModelScope.launch {
            try {
                _uiState.pokemon = pokemonRepository.getPokemonById(id)
            } catch (_: Exception) {
            } finally {
                _uiState.isLoading = false
            }
        }
    }
}

class MutablePokemonDetailsUiState : PokemonDetailsUiState {
    override var pokemon: PokemonDetail? by mutableStateOf(null)
    override var isLoading: Boolean by mutableStateOf(true)
}

@Stable
interface PokemonDetailsUiState {
    val pokemon: PokemonDetail?
    val isLoading: Boolean
}