package com.gilbersoncampos.pokeguide.data.mapper

import com.gilbersoncampos.pokeguide.data.model.Pokemon
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail
import com.gilbersoncampos.pokeguide.data.network.dto.PokemonEntryDto
import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto

fun PokemonEntryDto.toModel():Pokemon=
    Pokemon(this.entry_number, this.pokemon_species.name)
 fun ResponsePokemonDetailDto.toModel(): PokemonDetail =

    PokemonDetail(
        id = id,
        name = name,
        height = height,
        baseExperience = base_experience,
        isDefault = is_default,
        order = order,
        weight = weight,
        spriteDefault = sprites.front_default,
        spriteShiny = sprites.front_shiny,
        type1 = types[0].type.name,
        type2 = if (types.size > 1) types[1].type.name else null
    )