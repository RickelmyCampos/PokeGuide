package com.gilbersoncampos.pokeguide.ui.screen.homeScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.gilbersoncampos.pokeguide.navigation.Destinations

val ROUTE = Destinations.Home.route
fun NavGraphBuilder.homeScreen(navigateToDetails:(Int)->Unit,openSearch:Boolean,closeSearch:()->Unit) {
    composable(ROUTE) {
        HomeScreen(navigateToDetails=navigateToDetails,openSearch=openSearch,closeSearch=closeSearch)
    }
}

fun NavHostController.navigateToHome(navOptions: NavOptions?) {
    navigate(route = ROUTE, navOptions = navOptions)

}