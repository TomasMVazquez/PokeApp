package com.example.pokeapp.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.pokeapp.R

enum class NavItem(
    val navCommand: NavCommand,
    val icon: ImageVector,
    @StringRes val title: Int
) {
    POKEMONS(NavCommand.ContentType(Feature.POKEMON), Icons.Default.Home, R.string.title_pokemon),
    BY_TYPE(NavCommand.ContentType(Feature.BY_TYPE), Icons.Default.Face, R.string.filter)
}

sealed class NavCommand (
    internal val feature: Feature,
    internal val subRoute: String = "home",
    val navArgs: List<NavArg> = emptyList()
) {

    class ContentType(feature: Feature): NavCommand(feature = feature)

    class ContentDetail(feature: Feature): NavCommand(feature = feature, "detail", listOf(NavArg.Id)) {
        fun createNavRout(id: Int) = "${feature.route}/$subRoute/$id"
    }

    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(feature.route, subRoute).plus(argKeys).joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    Id("id", NavType.IntType)
}