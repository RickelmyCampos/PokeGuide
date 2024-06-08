package com.gilbersoncampos.pokeguide.data.network.retrofit

import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto
import retrofit2.Response

import retrofit2.http.GET

interface PokeApiNetworkService {
    @GET("/api/v2/pokedex/1")
    suspend fun getNationalDex():Response<ResponsePokedexDto>
}