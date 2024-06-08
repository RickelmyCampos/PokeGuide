package com.gilbersoncampos.pokeguide.data.network.retrofit

import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiNetworkService {
    @GET("/api/v2/pokedex/1")
    suspend fun getNationalDex():Response<ResponsePokedexDto>
    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemon(@Path("id") id:String):Response<ResponsePokemonDetailDto>
}