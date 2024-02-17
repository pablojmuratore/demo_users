package com.pablojmuratore.demousers.room.hilt

import android.content.Context
import com.pablojmuratore.demousers.room.AppDatabase
import com.pablojmuratore.demousers.room.daos.IUsersDao
import com.pablojmuratore.demousers.room.repositories.IRoomUsersRepository
import com.pablojmuratore.demousers.room.repositories.RoomUsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideUsersDao(database: AppDatabase): IUsersDao {
        return database.usersDao()
    }

    @Singleton
    @Provides
    fun provideRoomUsersRepository(usersDao: IUsersDao): IRoomUsersRepository {
        return RoomUsersRepository(usersDao)
    }
}