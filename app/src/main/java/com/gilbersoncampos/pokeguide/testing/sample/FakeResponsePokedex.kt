package com.gilbersoncampos.pokeguide.testing.sample

import com.gilbersoncampos.pokeguide.data.network.dto.PokemonEntryDto
import com.gilbersoncampos.pokeguide.data.network.dto.PokemonSpecieDto
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokedexDto

val fakeResponsePokedexDto = ResponsePokedexDto(
    pokemon_entries = listOf(
        PokemonEntryDto(
            entry_number = 1,
            pokemon_species = PokemonSpecieDto(name = "bulbasaur", url = "")
        ),
        PokemonEntryDto(
            entry_number = 2,
            pokemon_species = PokemonSpecieDto(name = "charmander", url = "")
        ),
        PokemonEntryDto(
            entry_number = 3,
            pokemon_species = PokemonSpecieDto(name = "pikachu", url = "")
        ),
        PokemonEntryDto(
            entry_number = 4,
            pokemon_species = PokemonSpecieDto(name = "ralts", url = "")
        ),
        PokemonEntryDto(
            entry_number = 5,
            pokemon_species = PokemonSpecieDto(name = "ninetails", url = "")
        ),
        PokemonEntryDto(
            entry_number = 6,
            pokemon_species = PokemonSpecieDto(name = "metagross", url = "")
        ),
    )
)