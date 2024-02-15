package com.pablojmuratore.demousers.features.users.models

data class User(
    val id: Int,
    val name: String,
    val email: String? = null
)