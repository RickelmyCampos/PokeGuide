package com.gilbersoncampos.pokeguide.ui.screen.pokemonDetailsScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.gilbersoncampos.pokeguide.navigation.Destinations
import com.gilbersoncampos.pokeguide.ui.screen.homeScreen.HomeScreen

val ROUTE = Destinations.PokemonDetails.route
fun NavGraphBuilder.pokemonDetailsScreen() {
    composable(ROUTE) { backStackEntry ->
        PokemonDetailsScreen(pokemonId = backStackEntry.arguments?.getString("id") ?: "")
    }
}

fun NavHostController.navigateToDetails(id: Int, navOptions: NavOptions? = null) {
    navigate(route = ROUTE.replace("{id}", id.toString()), navOptions = navOptions)

}