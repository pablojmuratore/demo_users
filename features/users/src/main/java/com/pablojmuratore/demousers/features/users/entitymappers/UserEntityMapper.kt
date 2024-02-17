package com.pablojmuratore.demousers.features.users.entitymappers

import com.pablojmuratore.demousers.core.IEntityMapper
import com.pablojmuratore.demousers.features.users.models.User
import com.pablojmuratore.demousers.room.models.UserEntity

class UserEntityMapper : IEntityMapper<UserEntity, User> {
    override fun mapFromEntity(entity: UserEntity): User {
        return User(
            id = entity.id,
            userName = entity.userName,
            email = entity.email,
            phone = entity.phone,
            website = entity.website
        )
    }

    override fun mapToEntity(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            userName = model.userName,
            email = model.email,
            phone = model.phone,
            website = model.website
        )
    }

    override fun mapFromEntitiesList(entities: List<UserEntity>): List<User> {
        return entities.map {
            mapFromEntity(it)
        }
    }

    override fun mapToEntitiesList(models: List<User>): List<UserEntity> {
        return models.map {
            mapToEntity(it)
        }
    }
}