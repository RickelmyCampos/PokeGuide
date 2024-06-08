package com.gilbersoncampos.pokeguide.data.repository

import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import javax.inject.Inject

interface PokemonRepository {
    suspend fun fechPokedex()
}

class PokemonRepositoryImpl @Inject constructor(private val network: NetworkDataSource) :
    PokemonRepository {
    override suspend fun fechPokedex() {
        network.fechPokedex()
    }

}