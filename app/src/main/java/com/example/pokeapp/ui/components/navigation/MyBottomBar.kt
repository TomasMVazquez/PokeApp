package com.example.pokeapp.ui.components.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pokeapp.ui.navigation.NavItem

@Composable
fun MyBottomBar(
    bottomNavOptions: List<NavItem>,
    currentRoute: String,
    onNavItemClick: (NavItem) -> Unit
) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.secondary) {
        bottomNavOptions.forEach { item ->
            val title = stringResource(item.title)
            BottomNavigationItem(
                selected = currentRoute.contains(item.navCommand.feature.route),
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = title
                    )
                },
                label = { Text(text = title) },
                alwaysShowLabel = false,
                onClick = { onNavItemClick(item) }
            )
        }
    }
}