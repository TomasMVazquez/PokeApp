package com.example.pokeapp.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokeapp.ui.screen.detail.PokemonDetail
import com.example.pokeapp.ui.screen.home.ByTypeScreen
import com.example.pokeapp.ui.screen.home.PokemonScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Feature.POKEMON.route
    ) {
        pokemonNav(navController = navController)
        typeNav(navController = navController)
    }

}

@ExperimentalFoundationApi
private fun NavGraphBuilder.pokemonNav(
    navController: NavController
) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.POKEMON).route,
        route = Feature.POKEMON.route
    ) {

        composable(navCommand = NavCommand.ContentType(Feature.POKEMON)) {
            PokemonScreen {
                navController.navigate(NavCommand.ContentDetail(Feature.POKEMON).createNavRout(it.id))
            }
        }

        composable(navCommand = NavCommand.ContentDetail(Feature.POKEMON)) { backStackEntry ->
            PokemonDetail(
                id = backStackEntry.findArg(NavArg.Id)
            )
        }
    }
}

@ExperimentalPagerApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.typeNav(
    navController: NavController
) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.BY_TYPE).route,
        route = Feature.BY_TYPE.route
    ) {

        composable(navCommand = NavCommand.ContentType(Feature.BY_TYPE)) {
            ByTypeScreen {
                navController.navigate(NavCommand.ContentDetail(Feature.BY_TYPE).createNavRout(it.id))
            }
        }

        composable(navCommand = NavCommand.ContentDetail(Feature.BY_TYPE)) { backStackEntry ->
            PokemonDetail(
                id = backStackEntry.findArg(NavArg.Id)
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ){
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(arg: NavArg): T {
    val value = arguments?.get(arg.key)
    requireNotNull(value)
    return value as T
}