package com.gilbersoncampos.pokeguide.data.network.datasource

import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto

interface NetworkDataSource {
    suspend fun fechPokedex():ResponsePokedexDto
}