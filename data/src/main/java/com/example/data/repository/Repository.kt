package com.example.data.repository

import com.example.domain.Pokemon

/**
 * To make ot more Generic should we use an Interface of a domain item
 */
abstract class Repository<T: Pokemon> {

    private var cache : List<T> = emptyList()

    internal suspend fun get(getAction: suspend () -> List<T>): List<T> {
        if(cache.isEmpty()) {
            cache = getAction()
        }
        return cache
    }

    internal suspend fun find(
        id: Int,
        findActionRemote: suspend () -> T
    ): T {
        val item = cache.find { it.id == id }
        if (item != null) return item

        return findActionRemote()
    }
}