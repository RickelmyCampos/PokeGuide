package com.gilbersoncampos.pokeguide.navigation
import androidx.navigation.NavController
import org.junit.Assert

fun NavController.assertCurrentRoute(expectedRoute:String){
    Assert.assertEquals(expectedRoute,currentBackStackEntry?.destination?.route)
}