package com.example.pokeapp.util

import com.example.domain.Type
import com.example.pokeapp.R

fun Type.getColors(): Pair<Int, Int> {
    return when(name){
        "normal" -> { (R.color.yellow to R.color.dark_yellow) }
        "fighting" -> { (R.color.yellow to R.color.dark_yellow) }
        "flying" -> { (R.color.yellow to R.color.dark_yellow) }
        "poison" -> { (R.color.yellow to R.color.dark_yellow) }
        "ground" -> { (R.color.yellow to R.color.dark_yellow) }
        "rock" -> { (R.color.yellow to R.color.dark_yellow) }
        "bug" -> { (R.color.yellow to R.color.dark_yellow) }
        "ghost" -> { (R.color.yellow to R.color.dark_yellow) }
        "steel" -> { (R.color.yellow to R.color.dark_yellow) }
        "fire" -> { (R.color.yellow to R.color.dark_yellow) }
        "water" -> { (R.color.yellow to R.color.dark_yellow) }
        "grass" -> { (R.color.yellow to R.color.dark_yellow) }
        "electric" -> { (R.color.yellow to R.color.dark_yellow) }
        "psychic" -> { (R.color.yellow to R.color.dark_yellow) }
        "ice" -> { (R.color.yellow to R.color.dark_yellow) }
        "dragon" -> { (R.color.yellow to R.color.dark_yellow) }
        "dark" -> { (R.color.yellow to R.color.dark_yellow) }
        "fairy" -> { (R.color.yellow to R.color.dark_yellow) }
        "shadow" -> { (R.color.yellow to R.color.dark_yellow) }
        "unknown" -> { (R.color.yellow to R.color.dark_yellow) }
        else -> { (R.color.yellow to R.color.dark_yellow) }
    }
}