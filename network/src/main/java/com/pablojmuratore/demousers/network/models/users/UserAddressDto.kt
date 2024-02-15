package com.pablojmuratore.demousers.network.models.users

import com.pablojmuratore.demousers.network.models.geo.GeoLocalizationInfo
import com.squareup.moshi.Json

data class UserAddressDto(
    val street: String,
    val suite: String? = null,
    val city: String,
    @Json(name = "zipcode") val zipCode: String? = null,
    val geo: GeoLocalizationInfo? = null
)