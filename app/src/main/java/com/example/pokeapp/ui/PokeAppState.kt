package com.example.pokeapp.ui

import android.util.Log
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokeapp.ui.navigation.NavItem
import com.example.pokeapp.ui.navigation.navigatePoppingUpToStartDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberPokeAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): PokeAppState = remember(scaffoldState, navController, coroutineScope) {
    PokeAppState(scaffoldState, navController, coroutineScope)
}

class PokeAppState (
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope,
) {
    companion object {
        val BOTTOM_NAV_OPTIONS = listOf(NavItem.POKEMONS, NavItem.BY_TYPE)
    }

    val currentRoute: String
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route
            ?: ""

    val showUpNavigation: Boolean
        @Composable get() {
            val isContained = !NavItem.values().map { it.navCommand.route }.contains(currentRoute)
            return currentRoute.isNotEmpty() && isContained
        }

    val showBottomNavigation: Boolean
        @Composable get() = BOTTOM_NAV_OPTIONS.any {
            // IT will only show on HOMES screens
            currentRoute.contains(it.navCommand.subRoute)
        }

    fun onUpClick() {
        navController.popBackStack()
    }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand.route)
    }

}