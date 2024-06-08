package com.gilbersoncampos.pokeguide.navigation

import android.R
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.gilbersoncampos.pokeguide.ui.screen.favoriteScreen.favoriteScreen
import com.gilbersoncampos.pokeguide.ui.screen.favoriteScreen.navigateToFavorite
import com.gilbersoncampos.pokeguide.ui.screen.homeScreen.homeScreen
import com.gilbersoncampos.pokeguide.ui.screen.homeScreen.navigateToHome
import com.gilbersoncampos.pokeguide.ui.screen.pokemonDetailsScreen.navigateToDetails
import com.gilbersoncampos.pokeguide.ui.screen.pokemonDetailsScreen.pokemonDetailsScreen

@Composable
fun NavGraphHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        homeScreen(navigateToDetails={navController.navigateToDetails(it)})
        favoriteScreen()
        pokemonDetailsScreen()
    }
}
fun NavHostController.navigateInBottomNavigation(destination: Destinations) {
    val navOptions = navOptions {
        launchSingleTop = true

        popUpTo(destination.route) {
            inclusive = true

        }
    }
    when (destination) {
        Destinations.Favorites -> navigateToFavorite(navOptions)
        Destinations.Home -> navigateToHome(navOptions)
        else -> {}
    }
}