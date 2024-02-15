package com.pablojmuratore.demousers.network.models.users

import com.squareup.moshi.Json

data class UserDto(
    val id: Int,
    @Json(name = "username") val userName: String,
    val email: String? = null,
    val address: UserAddressDto? = null,
    val phone: String? = null,
    val website: String? = null,
    val company: UserCompanyDto? = null
)