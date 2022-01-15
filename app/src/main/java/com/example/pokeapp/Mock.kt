package com.example.pokeapp

import com.example.domain.Pokemon
import com.example.domain.Type

val mock =
    Pokemon(
        1,
        "charmander","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/4.svg",
        type = listOf(Type(1,"grass"))
    )


/** TODO
 * - ViewModels
 * - Add Loading
 * - Error Handler
 * - Pagination
 * - filters (type, ... )
 * - Add evolutions to detail ?
 */

// * - Detail -> DONE