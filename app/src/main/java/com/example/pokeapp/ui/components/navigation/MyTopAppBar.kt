package com.example.pokeapp.ui.components.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pokeapp.R
import com.example.pokeapp.ui.components.generics.GenericNavigationAction
import com.example.pokeapp.ui.components.generics.NavigationType

enum class AppBarType {
    HOME,
    WITH_NAVIGATION_ACTION
}

@Composable
fun MyTopAppBar(appBarType: AppBarType, onUpClick: () -> Unit){

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.title_pokemon),
                style = MaterialTheme.typography.h2
            )
        },
        navigationIcon = {
            if (appBarType == AppBarType.WITH_NAVIGATION_ACTION)
                GenericNavigationAction(navigationType = NavigationType.NAVIGATION_BACK, onClick = onUpClick)
        }
    )

}