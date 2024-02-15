package com.pablojmuratore.demousers.network.hilt

import com.pablojmuratore.demousers.network.NetworkApi
import com.pablojmuratore.demousers.network.repositories.INetworkUsersRepository
import com.pablojmuratore.demousers.network.repositories.NetworkUsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideNetworkApi(): NetworkApi {
        return NetworkApi
    }

    @Singleton
    @Provides
    fun provideNetworkUsersRepository(networkApi: NetworkApi): INetworkUsersRepository {
        return NetworkUsersRepository(networkApi)
    }
}