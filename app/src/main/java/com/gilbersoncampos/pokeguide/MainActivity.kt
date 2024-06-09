package com.gilbersoncampos.pokeguide

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeGuideApp() {
    val navController = rememberNavController()
    val currentBackStack = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack.value?.destination?.route
    val isHome = currentRoute?.equals(Destinations.Home.route) ?: false
    var openSearch by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            if (!openSearch) {
                TopAppBar(
                    title = { Text(text = "Poke Guide") },
                    navigationIcon = {
                        if (!isHome)
                            IconButton(onClick = navController::navigateUp) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                    contentDescription = null
                                )
                            }
                    }, actions = {
                        if (isHome) {
                            IconButton(onClick = { openSearch = true }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "search"
                                )
                            }
                        }
                    })
            }
        },
        bottomBar = {
            if (!openSearch) {
                NavigationBar {
                    Destinations.BottomNavigation.bottomNavigationScreens.forEachIndexed { _, item ->
                        NavigationBarItem(
                            icon = {
                                val icon = item.icon
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
            }
        }) {

        Column(
            modifier = Modifier
                .padding(it)
        ) {
            NavGraphHost(
                navController = navController,
                openSearch = openSearch,
                closeSearch = { openSearch = false })
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