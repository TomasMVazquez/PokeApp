package com.example.pokeapp.ui.screen.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.onFailure
import com.example.data.onSuccess
import com.example.data.repository.PokemonRepository
import com.example.domain.Pokemon
import com.example.pokeapp.R
import com.example.pokeapp.data.network.NetworkDataSource
import com.example.pokeapp.ui.components.generics.GenericImageLoader
import com.example.pokeapp.ui.components.generics.ImageType
import com.example.pokeapp.ui.util.getColors

@Composable
fun PokemonDetail(id: Int) {
    var pokemonState by remember() { mutableStateOf<Pokemon?>(null) }

    LaunchedEffect(Unit){
        PokemonRepository(NetworkDataSource()).getPokemonDetail(id)
            .onSuccess { pokemonState = it }
            .onFailure {
                //TODO
            }
    }

    pokemonState?.let { pokemon ->
        PokemonScreen(pokemon = pokemon)
    }

}

@Composable
fun PokemonScreen(pokemon: Pokemon){
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = pokemon.name.toUpperCase(Locale.current),
            color = colorResource(id =  pokemon.getPrimaryType()?.getColors()?.first ?: R.color.black),
            style = MaterialTheme.typography.h2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            letterSpacing = 6.sp,
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GenericImageLoader(
                    type = ImageType.NORMAL,
                    url = pokemon.thumb,
                    description = pokemon.name,
                    contentScale = ContentScale.FillHeight
                )

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "${stringResource(R.string.height)} ${pokemon.getHeightMetres()} ${stringResource(R.string.metres)}"
                    )

                    Text(
                        text = "${stringResource(R.string.weight)} ${pokemon.getWeightKilogram()} ${stringResource(R.string.kg)}"
                    )
                }

            }
        }

        LazyColumn {

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            pokemon.abilities?.let {
                item {
                    Text(
                        text = stringResource(R.string.abilities),
                        style = MaterialTheme.typography.h6
                    )
                }
                items(it) { ability ->
                    Text(text = ability)
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            pokemon.moves?.let {
                item {
                    Text(
                        text = stringResource(R.string.moves),
                        style = MaterialTheme.typography.h6
                    )
                }
                items(it) { move ->
                    Text(text = move)
                }
            }
        }
    }
}