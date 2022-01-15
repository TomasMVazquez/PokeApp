package com.example.pokeapp.data.entities

data class Pokemon(
    val abilities: List<Abilities>?,
    val base_experience: Int,
    val forms: List<Form>?,
    val game_indices: List<GameIndice>?,
    val height: Double,
    val held_items: List<Items>?,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Moves>?,
    val name: String,
    val order: Int,
    val past_types: List<Any>?,
    val species: Species?,
    val sprites: Sprites?,
    val stats: List<Stats>?,
    val types: List<Types>?,
    val weight: Double
)