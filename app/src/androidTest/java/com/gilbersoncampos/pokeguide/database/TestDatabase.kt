package com.gilbersoncampos.pokeguide.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gilbersoncampos.pokeguide.data.local.dao.PokemonDao
import com.gilbersoncampos.pokeguide.data.local.database.AppDatabase
import com.gilbersoncampos.pokeguide.data.local.entity.PokemonEntity
import com.gilbersoncampos.pokeguide.data.mapper.toEntity
import com.gilbersoncampos.pokeguide.data.mapper.toModel
import com.gilbersoncampos.pokeguide.testing.sample.fakeResponseDetailPokemon
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import javax.inject.Inject


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class TestDatabase {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var userDao: PokemonDao

    @Inject
    lateinit var db: AppDatabase

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun savePokemonAndFindPokemon() = runBlocking {
        val pokemon: PokemonEntity = fakeResponseDetailPokemon.toModel().toEntity()
        userDao.savePokemon(pokemon)
        val byId = userDao.getPokemonById(1)
        assertEquals(byId?.id, 1)
    }
    @Test
    fun savePokemonsAndFindAllPokemon() = runBlocking {
        val pokemon1: PokemonEntity = fakeResponseDetailPokemon.toModel().toEntity()
        val pokemon2: PokemonEntity = fakeResponseDetailPokemon.toModel().copy(id = 2) .toEntity()
        userDao.savePokemon(pokemon1)
        userDao.savePokemon(pokemon2)
        val allPokemons = userDao.getAllPokemons().first()
        assertEquals(allPokemons.size, 2)
    }
}