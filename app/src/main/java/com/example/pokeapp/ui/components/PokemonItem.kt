package com.example.pokeapp.ui.components

import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.example.domain.Pokemon
import com.example.pokeapp.R
import com.example.pokeapp.ui.components.generics.GenericImageLoader
import com.example.pokeapp.ui.components.generics.ImageType
import com.example.pokeapp.ui.theme.Shapes
import com.example.pokeapp.ui.util.getColors

@Composable
fun PokemonItem(pokemon: Pokemon, onClick: () -> Unit){
    Card(
        modifier = Modifier
            .padding(4.dp)
            .size(200.dp)
            .clickable(onClick = onClick),
        backgroundColor = colorResource(id = pokemon.getPrimaryType()?.getColors()?.first ?: Color.BLUE),
        border = BorderStroke(5.dp, colorResource(id = pokemon.getPrimaryType()?.getColors()?.second ?: Color.RED)),
        shape = Shapes.large,
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier.weight(0.75f),
                contentAlignment = Alignment.Center
            ) {
                GenericImageLoader(
                    type = ImageType.NORMAL,
                    url = pokemon.thumb,
                    description = pokemon.name,
                    contentScale = ContentScale.FillWidth
                )
            }

            Text(
                text = pokemon.name.toUpperCase(Locale.current),
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}
