package com.example.pokeapp.ui.util

import androidx.annotation.StringRes
import com.example.domain.Type
import com.example.pokeapp.R

fun Type.getColors(): Pair<Int, Int> {
    return when(name){
        "normal" -> { (R.color.normal to R.color.normal_border) }
        "fighting" -> { (R.color.fighting to R.color.fighting_border) }
        "flying" -> { (R.color.flying to R.color.flying_border) }
        "poison" -> { (R.color.poison to R.color.poison_border) }
        "ground" -> { (R.color.ground to R.color.ground_border) }
        "rock" -> { (R.color.rock to R.color.rock_border) }
        "bug" -> { (R.color.bug to R.color.bug_border) }
        "ghost" -> { (R.color.ghost to R.color.ghost_border) }
        "steel" -> { (R.color.steel to R.color.steel_border) }
        "fire" -> { (R.color.fire to R.color.fire_border) }
        "water" -> { (R.color.water to R.color.water_border) }
        "grass" -> { (R.color.grass to R.color.grass_border) }
        "electric" -> { (R.color.electric to R.color.electric_border) }
        "psychic" -> { (R.color.psychic to R.color.psychic_border) }
        "ice" -> { (R.color.ice to R.color.ice_border) }
        "dragon" -> { (R.color.dragon to R.color.dragon_border) }
        "dark" -> { (R.color.dark to R.color.dark_border) }
        "fairy" -> { (R.color.fairy to R.color.fairy_border) }
        "shadow" -> { (R.color.shadow to R.color.shadow_border) }
        "unknown" -> { (R.color.yellow to R.color.dark_yellow) }
        else -> { (R.color.yellow to R.color.dark_yellow) }
    }
}

fun getTypes() = listOf(
    "normal",
    "fighting",
    "flying",
    "poison",
    "ground",
    "rock",
    "bug",
    "ghost",
    "steel",
    "fire",
    "water",
    "grass",
    "electric",
    "psychic",
    "ice",
    "dragon",
    "dark",
    "fairy",
    "shadow",
    "unknown"
)

@StringRes
fun String.getStringRes(): Int = when (this) {
    "normal" -> R.string.normal
    "fighting" -> R.string.fighting
    "flying" -> R.string.flying
    "poison" -> R.string.poison
    "ground" -> R.string.ground
    "rock" -> R.string.rock
    "bug" -> R.string.bug
    "ghost" -> R.string.ghost
    "steel" -> R.string.steel
    "fire" -> R.string.fire
    "water" -> R.string.water
    "grass" -> R.string.grass
    "electric" -> R.string.electric
    "psychic" -> R.string.psychic
    "ice" -> R.string.ice
    "dragon" -> R.string.dragon
    "dark" -> R.string.dark
    "fairy" -> R.string.fairy
    "shadow" -> R.string.shadow
    "unknown" -> R.string.unknown
    else -> R.string.unknown
}
