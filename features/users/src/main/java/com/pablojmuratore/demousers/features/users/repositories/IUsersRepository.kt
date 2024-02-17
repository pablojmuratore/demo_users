package com.pablojmuratore.demousers.features.users.repositories

import com.pablojmuratore.demousers.features.users.models.User
import kotlinx.coroutines.flow.Flow

interface IUsersRepository {
    fun getUsersFlow(): Flow<List<User>>

    suspend fun getUserById(userId: Int): User?

    suspend fun loadNetworkUsers()
}