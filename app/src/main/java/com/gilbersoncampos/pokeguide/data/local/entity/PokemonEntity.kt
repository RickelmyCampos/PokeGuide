package com.gilbersoncampos.pokeguide.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val baseExperience: Int,
    @ColumnInfo val height: Int,
    @ColumnInfo val isDefault: Boolean,
    @ColumnInfo val order: Int,
    @ColumnInfo val weight: Int,
    @ColumnInfo val spriteDefault: String,
    @ColumnInfo val spriteShiny: String,
    @ColumnInfo val type1: String,
    @ColumnInfo val type2: String?,
    @ColumnInfo val isFavorite: Boolean=true
)