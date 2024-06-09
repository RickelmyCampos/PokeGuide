package com.gilbersoncampos.pokeguide.di

import android.content.Context
import androidx.room.Room
import com.gilbersoncampos.pokeguide.data.local.dao.PokemonDao
import com.gilbersoncampos.pokeguide.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "pokemon_database").build()
    @Provides
    fun providesPokemonDao(appDatabase: AppDatabase):PokemonDao=appDatabase.pokemonDao()
}