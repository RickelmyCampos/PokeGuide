package com.gilbersoncampos.pokeguide.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gilbersoncampos.pokeguide.data.local.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon_table")
     fun getAllPokemons():Flow<List<PokemonEntity>>
    @Query("SELECT * FROM pokemon_table WHERE id LIKE :id")
    suspend fun getPokemonById(id:Int):PokemonEntity?
    @Insert()
    suspend fun savePokemon(pokemon:PokemonEntity)
    @Delete
    suspend fun removePokemon(pokemon:PokemonEntity)
}