package com.example.pokeapp.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells.Fixed
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.example.data.onFailure
import com.example.data.onSuccess
import com.example.data.repository.PokemonRepository
import com.example.domain.Pokemon
import com.example.domain.Type
import com.example.pokeapp.data.network.NetworkDataSource

@ExperimentalFoundationApi
@Composable
fun PokemonList(pokemonList: List<Pokemon>,onPokemonClick: (Pokemon) -> Unit) {

    LazyVerticalGrid(cells = Fixed(3)) {
        items(pokemonList) { pokemon ->
            PokemonItem(
                pokemon = pokemon,
                onClick = { onPokemonClick(pokemon) }
            )
        }
    }
}