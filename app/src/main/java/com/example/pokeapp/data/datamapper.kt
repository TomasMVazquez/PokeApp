package com.example.pokeapp.data

import com.example.pokeapp.data.entities.ApiResponse
import com.example.pokeapp.data.entities.ApiResult
import com.example.domain.Pokemon
import com.example.domain.Type
import com.example.pokeapp.data.entities.Types as ApiType
import com.example.pokeapp.data.entities.Pokemon as ApiPokemon

fun ApiResponse.toDomain(): List<Pokemon> {
    return this.results.map {
        Pokemon(
            id = it.url.split("/").dropLast(1).last().toInt(),
            name = it.name
        )
    }
}

fun ApiResult.getId(): Int {
    return url.split("/").dropLast(1).last().toInt()
}

fun ApiPokemon.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        thumb = sprites?.other?.dream_world?.front_default ?: sprites?.front_default,
        type = types?.let { list -> list.map { it.toDomain() } },
        abilities = abilities?.let { list -> list.map { it.ability?.name ?: "" } },
        height = height,
        weight = weight,
        moves = moves?.let { list -> list.map { it.move.name } }
    )
}

fun ApiType.toDomain(): Type {
    return Type(
        id = slot,
        name = type.name
    )
}