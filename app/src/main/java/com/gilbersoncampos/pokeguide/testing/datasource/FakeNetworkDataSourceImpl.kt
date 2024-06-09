package com.gilbersoncampos.pokeguide.testing.datasource

import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto
import com.gilbersoncampos.pokeguide.testing.sample.fakeResponseDetailPokemon
import com.gilbersoncampos.pokeguide.testing.sample.fakeResponsePokedexDto
import javax.inject.Inject

class FakeNetworkDataSourceImpl @Inject constructor(): NetworkDataSource {
    override suspend fun fechPokedex(): ResponsePokedexDto =
        fakeResponsePokedexDto


    override suspend fun getPokemonById(id: String): ResponsePokemonDetailDto =
        fakeResponseDetailPokemon


}