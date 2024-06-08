package com.gilbersoncampos.pokeguide.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gilbersoncampos.pokeguide.R

sealed class Destinations(val route:String, @StringRes  val name:Int,@DrawableRes val icon: Int?=null) {
    object Home:Destinations(route = "home",name=R.string.home_destination,icon = R.drawable.ic_home )
    object Favorites:Destinations(route = "favorites",name=R.string.favorites_destination,icon = R.drawable.ic_favorite)
    object PokemonDetails:Destinations(route = "pokemondetails/{id}",name=R.string.details)
    object BottomNavigation{
        val bottomNavigationScreens= listOf<Destinations>(Home,Favorites)
    }
}

