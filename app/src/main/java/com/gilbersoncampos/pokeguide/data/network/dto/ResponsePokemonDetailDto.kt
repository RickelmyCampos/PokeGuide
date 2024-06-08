package com.gilbersoncampos.pokeguide.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponsePokemonDetailDto(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val sprites: SpritesDto,
    val types: List<TypesDto>
)

@Serializable
data class TypesDto(val slot: Int, val type: TypeDto)

@Serializable
data class TypeDto(val name: String)

@Serializable
data class SpritesDto(val front_default: String, val front_shiny: String)
