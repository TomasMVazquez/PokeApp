package com.example.domain

data class Pokemon(
    val id: Int,
    val name: String,
    val thumb: String? = null,
    val type: List<Type>? = null,
    val abilities: List<String>? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val moves: List<String>? = null
) {
    fun getPrimaryType() =
        type?.let {
            if(it.size > 1 && it[0].name == "normal")
                Type(id = it[1].id, name = it[1].name)
            else
                Type(id = it[0].id, name = it[0].name)
        }

    fun getHeightMetres(): String = height?.div(10).toString()

    fun getWeightKilogram(): String = weight?.div(10).toString()
}