package com.example.pokeapp.ui.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.data.onFailure
import com.example.data.onSuccess
import com.example.data.repository.PokemonRepository
import com.example.domain.Pokemon
import com.example.pokeapp.data.network.NetworkDataSource
import com.example.pokeapp.ui.components.PokemonList
import com.example.pokeapp.ui.components.navigation.TypeFormatsTabRow
import com.example.pokeapp.ui.util.getTypes
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun ByTypeScreen(onPokemonClick: (Pokemon) -> Unit) {
    var pokemonListState by remember() { mutableStateOf(emptyList<Pokemon>()) }

    LaunchedEffect(Unit){
        PokemonRepository(NetworkDataSource()).getPokemonList()
            .onSuccess { pokemonListState = it }
            .onFailure {
                //TODO
            }
    }

    val pagerState = rememberPagerState()

    Column {
        TypeFormatsTabRow(pagerState = pagerState)

        HorizontalPager(
            count = getTypes().size,
            state = pagerState
        ) {
            ByTypeScreen(
                pokemonList = pokemonListState.filter { it.getPrimaryType()?.name == getTypes()[pagerState.currentPage] },
                onPokemonClick = onPokemonClick
            )
        }
    }

}

@ExperimentalFoundationApi
@Composable
fun ByTypeScreen(pokemonList: List<Pokemon>, onPokemonClick: (Pokemon) -> Unit){
    PokemonList(pokemonList = pokemonList,onPokemonClick = onPokemonClick)
}