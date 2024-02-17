package com.pablojmuratore.demousers.features.users.models

data class User(
    val id: Int,
    val userName: String,
    val email: String? = null,
    val phone: String? = null,
    val website: String? = null
)