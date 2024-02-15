package com.pablojmuratore.demousers.network.repositories

import com.pablojmuratore.demousers.network.models.users.UserDto

interface INetworkUsersRepository {
    suspend fun getUsers(): List<UserDto>
}