package com.gilbersoncampos.pokeguide.ui.screen.homeScreen

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {
    private var _uiState = MutableHomeUiState()
    val uiState: HomeUiState = _uiState

    init {
        fechPokedex()
    }

    fun fechPokedex() {
        viewModelScope.launch {
            try {
                _uiState.isLoading = true
                _uiState.pokedexList = pokemonRepository.fechPokedex()
            } catch (ex: Exception) {

            } finally {
                _uiState.isLoading = false
            }
        }
    }

    fun changeTextSearch(text: String) {
        _uiState.textSearch = text
        filterPokedex(text)
    }

    private fun filterPokedex(text: String) {
        if (text.isBlank()) {
            _uiState.pokedexFilter = emptyList()
            return
        }
        _uiState.pokedexFilter = _uiState.pokedexList.filter { pokemon ->
            pokemon.pokemonEntry.toString().contains(text, true) || pokemon.name.contains(
                text,
                true
            )
        }
    }
}

class MutableHomeUiState : HomeUiState {
    override var pokedexFilter: List<Pokemon> by mutableStateOf(emptyList())
    override var pokedexList: List<Pokemon> by mutableStateOf(emptyList())
    override var isLoading: Boolean by mutableStateOf(false)
    override var textSearch: String by mutableStateOf("")

}

@Stable
interface HomeUiState {
    val textSearch: String
    val pokedexFilter: List<Pokemon>
    val pokedexList: List<Pokemon>
    val isLoading: Boolean
}