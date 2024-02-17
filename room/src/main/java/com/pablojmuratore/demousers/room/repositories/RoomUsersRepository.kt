package com.pablojmuratore.demousers.room.repositories

import com.pablojmuratore.demousers.room.daos.IUsersDao
import com.pablojmuratore.demousers.room.models.UserEntity
import kotlinx.coroutines.flow.Flow

class RoomUsersRepository(
    private val usersDao: IUsersDao
) : IRoomUsersRepository {

    override suspend fun saveUser(user: UserEntity) {
        usersDao.insert(user)
    }

    override suspend fun saveUsers(users: List<UserEntity>) {
        usersDao.insertAll(users)
    }

    override fun getAllUsersFlow(): Flow<List<UserEntity>> {
        return usersDao.getAllFlow()
    }

    override suspend fun getById(userId: Int): UserEntity? {
        return usersDao.getById(userId)
    }
}
