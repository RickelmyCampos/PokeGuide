package com.gilbersoncampos.pokeguide.data.model

data class PokemonDetail(
    val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val spriteDefault: String,
    val spriteShiny: String,
    val type1: String,
    val type2: String?
)
