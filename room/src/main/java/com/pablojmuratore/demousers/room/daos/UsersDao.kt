package com.pablojmuratore.demousers.room.daos

import androidx.room.Dao
import androidx.room.Query
import com.pablojmuratore.demousers.room.models.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IUsersDao : IDao<UserEntity> {
    @Query("select * from users")
    fun getAllFlow(): Flow<List<UserEntity>>

    @Query("select * from users where id=:userId limit 1")
    fun getById(userId: Int): UserEntity?

    @Query("select * from users where rowid=:rowId limit 1")
    fun getByRowId(rowId: Long): UserEntity?

    @Query("delete from users where id=:userId")
    fun deleteById(userId: Int)

    @Query("delete from users")
    suspend fun deleteAll()
}