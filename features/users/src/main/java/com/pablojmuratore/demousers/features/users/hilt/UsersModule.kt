package com.pablojmuratore.demousers.features.users.hilt

import com.pablojmuratore.demousers.features.users.entitymappers.UserDtoEntityMapper
import com.pablojmuratore.demousers.features.users.entitymappers.UserEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UsersModule {
    @Singleton
    @Provides
    fun provideUserDtoEntityMapper(): UserDtoEntityMapper {
        return UserDtoEntityMapper()
    }

    @Singleton
    @Provides
    fun provideUserEntityMapper(): UserEntityMapper {
        return UserEntityMapper()
    }
}
