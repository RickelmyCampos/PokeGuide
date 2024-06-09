package com.gilbersoncampos.pokeguide.data.mapper

import com.gilbersoncampos.pokeguide.data.local.entity.PokemonEntity
import com.gilbersoncampos.pokeguide.data.model.PokemonDetail

fun PokemonDetail.toEntity(): PokemonEntity = PokemonEntity(
    id,
    name,
    baseExperience,
    height,
    isDefault,
    order,
    weight,
    spriteDefault,
    spriteShiny,
    type1,
    type2
)