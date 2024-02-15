package com.pablojmuratore.demousers.network.repositories

import com.pablojmuratore.demousers.network.NetworkApi
import com.pablojmuratore.demousers.network.models.users.UserDto

class NetworkUsersRepository(private val networkApi: NetworkApi) : INetworkUsersRepository {
    override suspend fun getUsers(): List<UserDto> {
        return networkApi.getUsers()
    }
}