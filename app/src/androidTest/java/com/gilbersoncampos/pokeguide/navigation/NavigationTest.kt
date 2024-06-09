package com.gilbersoncampos.pokeguide.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gilbersoncampos.pokeguide.MainActivity
import com.gilbersoncampos.pokeguide.R
import com.gilbersoncampos.pokeguide.testing.sample.fakeResponseDetailPokemon
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.properties.ReadOnlyProperty

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class NavigationTest {
    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get: Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    private fun AndroidComposeTestRule<*, *>.stringResource(@StringRes resId: Int) =
        ReadOnlyProperty<Any, String> { _, _ -> activity.getString(resId) }

    private val homeScreen by composeTestRule.stringResource(R.string.home_destination)
    private val favoriteScreen by composeTestRule.stringResource(R.string.favorites_destination)
    private val emptyFavoriteListText by composeTestRule.stringResource(R.string.empty_text_favorite_list)
    private val pokemon = "bulbasaur"
    private val favoriteIcon = "favoriteIcon"

    @Test
    fun firstScreen_isHome() {
        composeTestRule.apply {
            onNodeWithContentDescription("search").assertExists()
        }
    }

    @Test(expected = NoActivityResumedException::class)
    fun homeScreen_onBack_closeApp() {
        composeTestRule.apply {
            firstScreen_isHome()
            Espresso.pressBack()
        }
    }

    @Test
    fun homeScreen_navigateToFavorites_renderFavorites() {
        composeTestRule.apply {
            firstScreen_isHome()
            onNodeWithText(favoriteScreen).performClick()
            onNodeWithText(emptyFavoriteListText).assertExists()
        }
    }

    @Test
    fun homeScreen_onClickPokemon_renderPokemonDetailsScreen() {
        composeTestRule.apply {
            firstScreen_isHome()
            onNodeWithText(pokemon).performClick()
            onNodeWithText("${fakeResponseDetailPokemon.id} - ${fakeResponseDetailPokemon.name}").assertExists()
        }
    }
    @Test
    fun detailScreen_saveFavoritesAndNavigateToFavorites_renderFavoriteList() {
        composeTestRule.apply {
            homeScreen_onClickPokemon_renderPokemonDetailsScreen()
            onNodeWithContentDescription(favoriteIcon).performClick()
            onNodeWithText(favoriteScreen).performClick()
            onNodeWithText(emptyFavoriteListText).assertExists()
        }
    }


}