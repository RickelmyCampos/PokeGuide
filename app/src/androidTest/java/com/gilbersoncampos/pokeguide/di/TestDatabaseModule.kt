package com.gilbersoncampos.pokeguide.di

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.gilbersoncampos.pokeguide.data.local.dao.PokemonDao
import com.gilbersoncampos.pokeguide.data.local.database.AppDatabase
import com.gilbersoncampos.pokeguide.data.network.datasource.NetworkDataSource
import com.gilbersoncampos.pokeguide.testing.datasource.FakeNetworkDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object TestDatabaseModule {
    val context = ApplicationProvider.getApplicationContext<Context>()
    @Provides
    fun providesDatabase(): AppDatabase =
        Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
    @Provides
    fun providesPokemonDao(appDatabase: AppDatabase): PokemonDao =appDatabase.pokemonDao()
}