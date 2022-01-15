package com.example.pokeapp.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pokeapp.ui.components.navigation.AppBarType
import com.example.pokeapp.ui.components.navigation.MyBottomBar
import com.example.pokeapp.ui.components.navigation.MyTopAppBar
import com.example.pokeapp.ui.navigation.Navigation
import com.example.pokeapp.ui.theme.PokeAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun PokeApp(appState: PokeAppState = rememberPokeAppState()) {

    PokeScreen {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    appBarType = if (!appState.showUpNavigation) AppBarType.HOME else AppBarType.WITH_NAVIGATION_ACTION,
                    onUpClick = { appState.onUpClick() }
                )
             },
            bottomBar = {
                if (appState.showBottomNavigation) {
                    MyBottomBar(
                        bottomNavOptions = PokeAppState.BOTTOM_NAV_OPTIONS,
                        currentRoute = appState.currentRoute,
                        onNavItemClick = { appState.onNavItemClick(it) })
                }
            }
        ) { paddingValues ->

            Box(modifier = Modifier.padding(paddingValues)) {
                Navigation(navController = appState.navController)
            }

        }

    }
}

@Composable
fun PokeScreen(content: @Composable () -> Unit) {
    PokeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}