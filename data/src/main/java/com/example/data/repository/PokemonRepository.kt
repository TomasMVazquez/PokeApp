package com.example.data.repository

import com.example.data.Either
import com.example.data.datasources.RemoteDataSource
import com.example.domain.Error
import com.example.domain.Pokemon

class PokemonRepository (
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getPokemonList(): Either<List<Pokemon>, Error> {
        return remoteDataSource.getPokemonList()
    }

    suspend fun getPokemonDetail(id: Int): Either<Pokemon, Error> {
        return remoteDataSource.getPokemonDetail(id)
    }

}