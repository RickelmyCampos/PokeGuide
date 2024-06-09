package com.gilbersoncampos.pokeguide.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gilbersoncampos.pokeguide.data.local.dao.PokemonDao
import com.gilbersoncampos.pokeguide.data.local.entity.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pokemonDao():PokemonDao
}