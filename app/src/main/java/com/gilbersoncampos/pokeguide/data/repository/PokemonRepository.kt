package com.gilbersoncampos.pokeguide.data.repository

import com.gilbersoncampos.pokeguide.data.mapper.toModel
import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail
import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto
import javax.inject.Inject

interface PokemonRepository {
    suspend fun fechPokedex(): List<Pokemon>
    suspend fun getPokemonById(id: String): PokemonDetail
}

class PokemonRepositoryImpl @Inject constructor(private val network: NetworkDataSource) :
    PokemonRepository {
    override suspend fun fechPokedex(): List<Pokemon> {
        val response = network.fechPokedex()
        return response.pokemon_entries.map { it.toModel() }
    }

    override suspend fun getPokemonById(id: String): PokemonDetail {
        val response = network.getPokemonById(id)
        return response.toModel()
    }

}



