package com.pablojmuratore.demousers.features.users.repositories

import android.util.Log
import com.pablojmuratore.demousers.features.users.entitymappers.UserDtoEntityMapper
import com.pablojmuratore.demousers.features.users.entitymappers.UserEntityMapper
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.network.repositories.INetworkUsersRepository
import com.pablojmuratore.demousers.room.repositories.IRoomUsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class UsersRepository(
    private val networkUsersRepository: INetworkUsersRepository,
    private val roomUsersRepository: IRoomUsersRepository,
    private val userDtoEntityMapper: UserDtoEntityMapper,
    private val userEntityMapper: UserEntityMapper
) : IUsersRepository {

    override fun getUsersFlow(): Flow<List<User>> {
        return try {
            roomUsersRepository.getAllUsersFlow().map {
                userEntityMapper.mapFromEntitiesList(it)
            }
        } catch (e: Exception) {
            Log.d("---x", "getUsers ( UsersRepository ) - ERROR: ${e.message}")

            flowOf(emptyList())
        }
    }

    override suspend fun getUserById(userId: Int): User? {
        val userEntity = roomUsersRepository.getById(userId)

        return userEntity?.let {
            userEntityMapper.mapFromEntity(it)
        }
    }

    override suspend fun loadNetworkUsers() {
        val networkUsers = networkUsersRepository.getUsers()
        val users = userDtoEntityMapper.mapFromEntitiesList(networkUsers)
        val userEntities = userEntityMapper.mapToEntitiesList(users)

        roomUsersRepository.saveUsers(userEntities)
    }
}
