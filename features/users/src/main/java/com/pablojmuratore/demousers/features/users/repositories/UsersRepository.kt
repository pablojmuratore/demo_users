package com.pablojmuratore.demousers.features.users.repositories

import com.pablojmuratore.demousers.features.users.converters.UserDtoEntityMapper
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.network.repositories.INetworkUsersRepository

class UsersRepository(
    private val networkUsersRepository: INetworkUsersRepository,
    private val userDtoEntityMapper: UserDtoEntityMapper
) : IUsersRepository {
    override suspend fun getNetworkUsers(): List<User> {
        return userDtoEntityMapper.mapFromEntitiesList(networkUsersRepository.getUsers())
    }
}