package com.example.pokeapp.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.*
import com.example.data.onFailure
import com.example.data.onSuccess
import com.example.data.repository.PokemonRepository
import com.example.domain.Pokemon
import com.example.pokeapp.data.network.NetworkDataSource
import com.example.pokeapp.ui.components.PokemonList

@ExperimentalFoundationApi
@Composable
fun PokemonScreen(onPokemonClick: (Pokemon) -> Unit) {
    var pokemonListState by remember() { mutableStateOf(emptyList<Pokemon>()) }

    LaunchedEffect(Unit){
        PokemonRepository(NetworkDataSource()).getPokemonList()
            .onSuccess { pokemonListState = it }
            .onFailure {
                //TODO
            }
    }

    PokemonScreen(
        pokemonList = pokemonListState,
        onPokemonClick = onPokemonClick
    )
}

@ExperimentalFoundationApi
@Composable
fun PokemonScreen(pokemonList: List<Pokemon>, onPokemonClick: (Pokemon) -> Unit){
    PokemonList(pokemonList = pokemonList,onPokemonClick = onPokemonClick)
}