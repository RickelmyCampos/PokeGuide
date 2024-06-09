package com.gilbersoncampos.pokeguide.data.repository

import com.gilbersoncampos.pokeguide.data.local.dao.PokemonDao
import com.gilbersoncampos.pokeguide.data.mapper.toEntity
import com.gilbersoncampos.pokeguide.data.mapper.toModel
import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail
import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

interface PokemonRepository {
    suspend fun fechPokedex(): List<Pokemon>
    suspend fun getPokemonById(id: String): PokemonDetail
     fun getAllFavorites(): Flow<List<PokemonDetail>>
    suspend fun saveFavoritePokemon(pokemonDetail: PokemonDetail)
    suspend fun getLocalPokemon(id: Int): PokemonDetail?
    suspend fun removeFavoritePokemon(pokemon:  PokemonDetail)
}

class PokemonRepositoryImpl @Inject constructor(
    private val network: NetworkDataSource,
    private val local: PokemonDao
) :
    PokemonRepository {
    override suspend fun fechPokedex(): List<Pokemon> {
        val response = network.fechPokedex()
        return response.pokemon_entries.map { it.toModel() }
    }

    override suspend fun getPokemonById(id: String): PokemonDetail {
        val response = network.getPokemonById(id)
        return response.toModel()
    }

    override  fun getAllFavorites(): Flow<List<PokemonDetail>> =
        local.getAllPokemons().map { list->list.filter { it.isFavorite }.map { it.toModel() } }


    override suspend fun saveFavoritePokemon(pokemonDetail: PokemonDetail) {
        local.savePokemon(pokemon = pokemonDetail.toEntity())
    }

    override suspend fun getLocalPokemon(id: Int): PokemonDetail? {
        return local.getPokemonById(id)?.toModel()
    }

    override suspend fun removeFavoritePokemon(pokemon:  PokemonDetail) {

            local.removePokemon(pokemon.toEntity())

    }


}



