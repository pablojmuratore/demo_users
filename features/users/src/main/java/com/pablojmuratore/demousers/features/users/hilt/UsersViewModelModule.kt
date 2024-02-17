package com.pablojmuratore.demousers.features.users.hilt

import com.pablojmuratore.demousers.features.users.entitymappers.UserDtoEntityMapper
import com.pablojmuratore.demousers.features.users.entitymappers.UserEntityMapper
import com.pablojmuratore.demousers.features.users.repositories.IUsersRepository
import com.pablojmuratore.demousers.features.users.repositories.UsersRepository
import com.pablojmuratore.demousers.network.repositories.INetworkUsersRepository
import com.pablojmuratore.demousers.room.repositories.IRoomUsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class UsersViewModelModule {
    @ViewModelScoped
    @Provides
    fun provideUsersRepository(
        networkUsersRepository: INetworkUsersRepository,
        roomUsersRepository: IRoomUsersRepository,
        userDtoEntityMapper: UserDtoEntityMapper,
        userEntityMapper: UserEntityMapper
    ): IUsersRepository {
        return UsersRepository(
            networkUsersRepository,
            roomUsersRepository,
            userDtoEntityMapper,
            userEntityMapper
        )
    }
}