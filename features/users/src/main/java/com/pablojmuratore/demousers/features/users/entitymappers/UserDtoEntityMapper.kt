package com.pablojmuratore.demousers.features.users.entitymappers

import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.network.models.users.UserDto

class UserDtoEntityMapper {
    fun mapFromEntity(entity: UserDto): User {
        return User(
            id = entity.id,
            userName = entity.userName,
            email = entity.email,
            phone = entity.phone,
            website = entity.website
        )
    }

    fun mapFromEntitiesList(entities: List<UserDto>): List<User> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}