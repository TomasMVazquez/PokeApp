package com.example.data.datasources

import com.example.data.Either
import com.example.domain.Error
import com.example.domain.Pokemon

interface RemoteDataSource {

    suspend fun getPokemonList(): Either<List<Pokemon>, Error>

    suspend fun getPokemonDetail(id: Int): Either<Pokemon, Error>

}