package com.example.pokeapp.data.entities

data class Moves(
    val move: Move,
    val version_group_details: List<VersionGroupDetail>?
)