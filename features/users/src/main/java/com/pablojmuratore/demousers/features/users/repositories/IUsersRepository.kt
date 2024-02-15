package com.pablojmuratore.demousers.features.users.repositories

import com.pablojmuratore.demousers.features.users.models.User

interface IUsersRepository {
    suspend fun getNetworkUsers(): List<User>
}