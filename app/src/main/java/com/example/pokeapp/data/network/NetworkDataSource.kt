package com.example.pokeapp.data.network

import com.example.data.*
import com.example.data.datasources.RemoteDataSource
import com.example.domain.Error
import com.example.domain.Pokemon
import com.example.domain.toError
import com.example.pokeapp.data.getId
import com.example.pokeapp.data.toDomain

class NetworkDataSource : RemoteDataSource {

    override suspend fun getPokemonList(): Either<List<Pokemon>, Error> {
        val api = PokemonApiService.retrofitService.getPokemonListAsync()
        return try {
            if (api.isSuccessful) {
                if (api.body() == null)
                    return eitherFailure(Error.Server(api.code()))
                else {
                    val list = mutableListOf<Pokemon>()
                    var error: Error? = null
                    api.body()!!.results.map { apiResult ->
                        getPokemonDetail(apiResult.getId())
                            .onSuccess { list.add(it) }
                            .onFailure { error = it }
                    }
                    if (error != null) eitherFailure(error)
                    eitherSuccess(list)
                }
            }else {
                eitherFailure(Error.Server(api.code()))
            }
        }catch (e: Exception) {
            eitherFailure(e.toError())
        }
    }

    override suspend fun getPokemonDetail(id: Int): Either<Pokemon, Error> {
        val api = PokemonApiService.retrofitService.getPokemonDetailAsync(id)
        return try {
            if (api.isSuccessful){
                eitherSuccess(api.body()!!.toDomain())
            }else {
                eitherFailure(Error.Server(api.code()))
            }
        }catch (e: Exception) {
            eitherFailure(e.toError())
        }
    }

}