package com.gilbersoncampos.pokeguide.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ResponsePokedexDto(val pokemon_entries: List<PokemonEntryDto>)

@Serializable
data class PokemonEntryDto(
    val entry_number: Int,
    val pokemon_species: PokemonSpecieDto
)
@Serializable
data class PokemonSpecieDto(val name: String, val url: String)
