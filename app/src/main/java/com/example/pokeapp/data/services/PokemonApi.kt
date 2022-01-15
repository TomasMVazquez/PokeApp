package com.example.pokeapp.data.services

import com.example.pokeapp.data.POKEMON_ENDPOINT
import com.example.pokeapp.data.entities.ApiResponse
import com.example.pokeapp.data.entities.Pokemon
import com.example.pokeapp.data.POKEMON_DETAIL_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET(POKEMON_ENDPOINT)
    suspend fun getPokemonListAsync(): Response<ApiResponse>

    @GET(POKEMON_DETAIL_ENDPOINT)
    suspend fun getPokemonDetailAsync(
        @Path("id") id: Int
    ): Response<Pokemon>

}