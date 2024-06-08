package com.gilbersoncampos.pokeguide.di

import com.gilbersoncampos.pokeguide.data.repository.PokemonRepository
import com.gilbersoncampos.pokeguide.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
   abstract fun bindPokemonRepository(pokemonRepository: PokemonRepositoryImpl):PokemonRepository

}