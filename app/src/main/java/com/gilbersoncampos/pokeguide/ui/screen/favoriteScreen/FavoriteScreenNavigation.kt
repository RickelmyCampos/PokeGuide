package com.gilbersoncampos.pokeguide.ui.screen.favoriteScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.gilbersoncampos.pokeguide.navigation.Destinations
import com.gilbersoncampos.pokeguide.ui.screen.homeScreen.HomeScreen

val ROUTE = Destinations.Favorites.route
fun NavGraphBuilder.favoriteScreen() {
    composable(ROUTE) {
        FavoriteScreen()
    }
}

fun NavHostController.navigateToFavorite(navOptions: NavOptions?) {
    navigate(route = ROUTE, navOptions = navOptions)

}