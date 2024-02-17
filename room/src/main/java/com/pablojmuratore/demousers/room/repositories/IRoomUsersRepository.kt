package com.pablojmuratore.demousers.room.repositories

import com.pablojmuratore.demousers.room.models.UserEntity
import kotlinx.coroutines.flow.Flow

interface IRoomUsersRepository {
    suspend fun saveUser(user: UserEntity)
    suspend fun saveUsers(users: List<UserEntity>)

    fun getAllUsersFlow(): Flow<List<UserEntity>>
    suspend fun getById(userId: Int): UserEntity?
}