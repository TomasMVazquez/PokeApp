package com.example.pokeapp.ui.components.generics

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationType{
    NAVIGATION_BACK,
    NAVIGATION_DRAWER,
    ACTION_SEARCH,
    ACTION_SHARE,
    ACTION_SETTINGS,
    ACTION_CUSTOM
}

@Composable
fun GenericNavigationAction(
    navigationType: NavigationType,
    icon: ImageVector? = null,
    description: String? = null,
    onClick: () -> Unit
){
    when(navigationType){
        NavigationType.NAVIGATION_BACK -> {
            NavigationBack(
                icon = icon,
                description = description,
                onClick = onClick
            )
        }
        NavigationType.NAVIGATION_DRAWER -> {
            NavigationMenu(
                icon = icon,
                description = description,
                onClick = onClick
            )
        }

        NavigationType.ACTION_SEARCH -> {
            ActionSearch(
                icon = icon,
                description = description,
                onClick = onClick
            )
        }
        NavigationType.ACTION_SHARE -> {
            ActionShare(
                icon = icon,
                description = description,
                onClick = onClick
            )
        }
        NavigationType.ACTION_SETTINGS -> {
            ActionSettings(
                icon = icon,
                description = description,
                onClick = onClick
            )
        }
        NavigationType.ACTION_CUSTOM -> {
            CustomAction(
                icon = icon,
                description = description,
                onClick = onClick
            )
        }
    }
}

@Composable
fun NavigationBack(icon: ImageVector?, description: String?, onClick: () -> Unit){

    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon ?: Icons.Default.ArrowBack,
            contentDescription = if (description.isNullOrEmpty()) description else "Go Back"
        )
    }

}

@Composable
fun NavigationMenu(icon: ImageVector?, description: String?, onClick: () -> Unit){

    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon ?: Icons.Default.Menu,
            contentDescription = description ?: "open menu drawer"
        )
    }

}

@Composable
fun ActionSearch(icon: ImageVector?, description: String?, onClick: () -> Unit){

    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon ?: Icons.Default.Search,
            contentDescription = description ?: "Go to search"
        )
    }

}

@Composable
fun ActionShare(icon: ImageVector?, description: String?, onClick: () -> Unit){

    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon ?: Icons.Default.Share,
            contentDescription = description ?: "share action"
        )
    }

}

@Composable
fun ActionSettings(icon: ImageVector?, description: String?, onClick: () -> Unit){

    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon ?: Icons.Default.Settings,
            contentDescription = description ?: "go to settings"
        )
    }

}

@Composable
fun CustomAction(icon: ImageVector?, description: String?, onClick: () -> Unit){

    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon ?: Icons.Default.Home,
            contentDescription = description ?: "Home"
        )
    }

}