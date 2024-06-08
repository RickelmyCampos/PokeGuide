package com.gilbersoncampos.pokeguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gilbersoncampos.pokeguide.navigation.Destinations
import com.gilbersoncampos.pokeguide.navigation.NavGraphHost
import com.gilbersoncampos.pokeguide.navigation.navigateInBottomNavigation
import com.gilbersoncampos.pokeguide.ui.theme.PokeGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeGuideTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokeGuideApp()
                }
            }
        }
    }
}

@Composable
fun PokeGuideApp() {
    val navController = rememberNavController()
    val currentBackStack=navController.currentBackStackEntryAsState()
    val currentRoute=currentBackStack.value?.destination?.route
    Scaffold(bottomBar = {
        NavigationBar {
            Destinations.BottomNavigation.bottomNavigationScreens.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        val icon=item.icon
                        icon?.let {
                            Icon(
                                painter = painterResource(id = it),
                                contentDescription = null
                            )
                        }

                    },
                    label = { Text(stringResource(id = item.name)) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigateInBottomNavigation(item)
                        //selectedItem = index
                    }
                )
            }
        }
    }) {

        Column(
            modifier = Modifier
                .padding(it)
        ) {
            NavGraphHost(navController = navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeGuideTheme {
        PokeGuideApp()
    }
}