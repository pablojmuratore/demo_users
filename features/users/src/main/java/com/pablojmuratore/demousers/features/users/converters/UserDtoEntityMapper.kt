package com.pablojmuratore.demousers.features.users.converters

import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.network.models.users.UserDto

class UserDtoEntityMapper {
    fun mapFromEntity(entity: UserDto): User {
        return User(
            id = entity.id,
            name = entity.userName,
            email = entity.email
        )
    }

    fun mapFromEntitiesList(entities: List<UserDto>): List<User> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}