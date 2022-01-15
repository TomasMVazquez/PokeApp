package com.example.data.entities

data class ApiResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ApiResult>
)