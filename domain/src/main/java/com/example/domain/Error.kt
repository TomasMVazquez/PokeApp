package com.example.domain

import java.io.IOException

/**
 * TODO
 */
sealed class Error  {
    object InitialState: Error()
    class Server(val code: Int): Error()
    object Connectivity: Error()
    class Unknown(val msg: String): Error()
}

fun Exception.toError(): Error = when(this) {
    is IOException -> Error.Connectivity
    //is HTTPException -> Error.Server(statusCode)
    else -> Error.Unknown(message ?: "")
}