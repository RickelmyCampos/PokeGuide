package com.gilbersoncampos.pokeguide.data.network.datasource

import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto

interface NetworkDataSource {
    suspend fun fechPokedex():ResponsePokedexDto
    suspend fun getPokemonById(id:String):ResponsePokemonDetailDto
}