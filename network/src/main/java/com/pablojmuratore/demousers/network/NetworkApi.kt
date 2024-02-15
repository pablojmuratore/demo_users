package com.pablojmuratore.demousers.network

import com.pablojmuratore.demousers.network.models.users.UserDto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.PROJECT_ENDPOINT)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(OkHttpClientCustom.getLoggingInterceptor())
    .build()

interface INetworkApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>
}

object NetworkApi {
    private val retrofitService by lazy { retrofit.create(INetworkApi::class.java) }

    suspend fun getUsers(): List<UserDto> {
        return retrofitService.getUsers()
    }
}