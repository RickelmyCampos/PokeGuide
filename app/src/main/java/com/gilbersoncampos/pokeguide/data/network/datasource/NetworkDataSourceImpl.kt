package com.gilbersoncampos.pokeguide.data.network.datasource

import android.util.Log
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto
import com.gilbersoncampos.pokeguide.data.network.retrofit.PokeApiNetworkService
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val service: PokeApiNetworkService
) : NetworkDataSource {
    override suspend fun fechPokedex(): ResponsePokedexDto {
        return try {
            val call = service.getNationalDex()
            val response = call.body()
            if (!call.isSuccessful || response == null) throw Exception("Não foi possivel buscar a pokedex")
            Log.w("fechPokedex", response.toString())
            response
        } catch (ex: Exception) {
            throw Exception("Erro :${ex.message}")
        }
    }
}