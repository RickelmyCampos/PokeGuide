package com.gilbersoncampos.pokeguide.testing.sample

import com.gilbersoncampos.pokeguide.data.network.dto.ResponsePokemonDetailDto
import com.gilbersoncampos.pokeguide.data.network.dto.SpritesDto
import com.gilbersoncampos.pokeguide.data.network.dto.TypeDto
import com.gilbersoncampos.pokeguide.data.network.dto.TypesDto

val fakeResponseDetailPokemon = ResponsePokemonDetailDto(
    id = 1,
    name = "bubasaur",
    base_experience = 32,
    height = 30,
    is_default = true,
    order = 20,
    weight = 42,
    sprites = SpritesDto(front_default = "image", front_shiny = "image2"),
    types = listOf(
        TypesDto(slot = 1, type = TypeDto(name = "grass")),
        TypesDto(slot = 2, type = TypeDto(name = "poison"))
    )
)