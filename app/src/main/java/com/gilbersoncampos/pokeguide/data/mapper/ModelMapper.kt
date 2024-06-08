package com.gilbersoncampos.pokeguide.data.mapper

import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.data.network.dto.PokemonEntryDto

fun PokemonEntryDto.toModel():Pokemon=
    Pokemon(this.entry_number, this.pokemon_species.name)
