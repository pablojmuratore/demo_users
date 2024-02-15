package com.pablojmuratore.demousers.features.users.hilt

import com.pablojmuratore.demousers.features.users.converters.UserDtoEntityMapper
import com.pablojmuratore.demousers.features.users.repositories.IUsersRepository
import com.pablojmuratore.demousers.features.users.repositories.UsersRepository
import com.pablojmuratore.demousers.network.repositories.INetworkUsersRepository
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
        userDtoEntityMapper: UserDtoEntityMapper
    ): IUsersRepository {
        return UsersRepository(networkUsersRepository, userDtoEntityMapper)
    }
}