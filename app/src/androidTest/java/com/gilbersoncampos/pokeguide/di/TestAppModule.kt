package com.gilbersoncampos.pokeguide.di

import com.gilbersoncampos.pokeguide.data.repository.PokemonRepository
import com.gilbersoncampos.pokeguide.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
abstract class TestAppModule {
    @Binds
    abstract fun bindPokemonRepository(pokemonRepository: PokemonRepositoryImpl): PokemonRepository
}