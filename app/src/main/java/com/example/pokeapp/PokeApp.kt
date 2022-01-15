package com.example.pokeapp

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.pokeapp.ui.theme.PokeAppTheme

@Composable
fun PokeApp(content: @Composable () -> Unit) {
    PokeAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}